package spatial.hibernate.app;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import spatial.hibernate.util.HibernateUtil;

import com.vividsolutions.jts.geom.Coordinate;

public class MapTest {
	
	public static void main(String[] args) throws Exception{
		queryAreaCoords2();
	}
	
	public static void queryDeviceInArea(){
		
		String sql = 
			"select {lr.*}                                                                        " + 
			"  from (select mdsys.sdo_geometry(2001,                                            " + 
			"                                  8307,                                            " + 
			"                                  mdsys.sdo_point_type(latitude,                   " + 
			"                                                       longitude,                  " + 
			"                                                       null),                      " + 
			"                                  NULL,                                            " + 
			"                                  NULL) loc,                                       " + 
			"               t.id tid                                                              " + 
			"          from t_last_locrecord t) rec,                                              " + 
			"       t_maparea area,                                                             " + 
			"       t_last_locrecord lr                                                         " + 
			" where area.area_id = 1                                                            " + 
			"   and rec.tid = lr.id                                                              " + 
			"   and mdsys.sdo_relate(area.shape, rec.loc, 'mask=contains') <> 'TRUE'             " ;
		
		Session session = HibernateUtil.getSession();

		SQLQuery sqlQuery = session.createSQLQuery(sql);
		
		sqlQuery.addEntity("lr", spatial.hibernate.domain.LastRecord.class);
		
		List list = sqlQuery.list();
		
		session.close();
		
		System.out.println(list.size());
		
	}
	
	public static void queryDeviceInArea2() throws Exception{
		
		String sql = 
			" select lr.*                                                                 " + 
			"   from (select mdsys.sdo_geometry(2001,                                     " + 
			"                                   8307,                                     " + 
			"                                   mdsys.sdo_point_type(latitude,            " + 
			"                                                        longitude,           " + 
			"                                                        null),               " + 
			"                                   NULL,                                     " + 
			"                                   NULL) loc,                                " + 
			"                t.id tid                                                     " + 
			"           from t_last_locrecord t) rec,                                     " + 
			"        t_maparea area,                                                      " + 
			"        t_last_locrecord lr                                                  " + 
			"  where area.area_id = 1                                                     " + 
			"    and lr.device_id in                                                      " + 
			"        (select loc.device_id                                                " + 
		    "           from t_last_locrecord loc                                         " + 
		    "           left join ref_term_pgroup ref on loc.device_id = ref.tid          " + 
		    "           left join t_privilage_group grp on ref.gid = grp.gid              " + 
		    "          where grp.eid = 'root')                                            " + 
		    "    and mdsys.sdo_relate(area.shape, rec.loc, 'mask=contains') = 'TRUE'      " ;
		
		
		Session session = HibernateUtil.getSession();
		
		Connection conn = session.connection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		int i = 0;
		while(rs.next()){
			i++;
		}
		System.out.println(i);
		
		session.close();
		
		
	}
	
	public static void queryAreaCoords(){
		
		StringBuffer buffer = new StringBuffer();
		
		String hql = "select ma.shape from MapArea ma where ma.areaId='1'";
//		String sql = "select ma.shape from t_maparea ma where ma.area_id='1'";

		Session session = HibernateUtil.getSession();

		Query query = session.createQuery(hql);
//		Query query = session.createSQLQuery(sql);

		List<com.vividsolutions.jts.geom.Polygon> list = query.list();

		if( list.size()!=0 ){
			Coordinate[] coordinates = list.get(0).getCoordinates();
			for( int i=0; i<coordinates.length; i++ ){
				buffer.append(coordinates[i].x + "," + coordinates[i].y + ";");
			}
		}
		
		session.close();
		
		System.out.println(buffer.toString());
		
	}

	public static void queryAreaCoords2() throws Exception{
		
		StringBuffer buffer = new StringBuffer();
		
		String sql = "select t.shape.sdo_ordinates from t_maparea t where t.area_id=1222";
		
		Session session = HibernateUtil.getSession();
		
		Connection conn = session.connection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			int i = 0;
			Array array = rs.getArray(1);
			ResultSet innerRs = array.getResultSet();
			while (innerRs.next()) {
				i++;
				String str = innerRs.getString(2);
				if(i%2==1)
					buffer.append(str).append(",");
				else
					buffer.append(str).append(";");
			}
		}
		
		session.close();
		
		String coords = buffer.toString().substring(0, buffer.toString().length()-1);
		System.out.println(coords);
		
	}

}
