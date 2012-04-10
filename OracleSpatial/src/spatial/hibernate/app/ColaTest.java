package spatial.hibernate.app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import spatial.hibernate.util.HibernateUtil;

import com.vividsolutions.jts.geom.Coordinate;

public class ColaTest {

	public static void main(String[] args) {
		
	}
	

	public void colaTest() {
		
		String hql = "select cm.shape from ColaMarkets cm where cm.name='cola_2012'";

		Session session = HibernateUtil.getSession();

		Query query = session.createQuery(hql);

		List<com.vividsolutions.jts.geom.Polygon> list = query.list();

		Coordinate[] coordinates = list.get(0).getCoordinates();

		System.out.println(coordinates);
	}

}
