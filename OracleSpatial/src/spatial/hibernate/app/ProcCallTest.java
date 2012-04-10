package spatial.hibernate.app;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Session;

import spatial.hibernate.util.FileUtil;
import spatial.hibernate.util.HibernateUtil;

public class ProcCallTest {
	
	public static void main(String[] args) throws Exception{
		
		String code = "0312";
		String name = "createdbyjavacode";
		String gid = "root";
		String points = FileUtil.readToBuffer(FileUtil.getBinPath() + "\\points.txt", "utf-8");
		System.out.println( ">>" + points + "<<");
//		String points = "109.460907,34.392748,109.460964,34.392575,109.461080,34.392408";
//		String points = "1,1,2,2,3,3,4,4,1,1";
		callProcedure("{Call proc_insert_maparea(?,?,?,?)}", new String[]{code, name, gid, points});
		
		
	}

	public static void callProcedure(String procString, String... params) throws Exception {
		Session session = HibernateUtil.getSession();
		CallableStatement callStmt = null;
		try {
			callStmt = session.connection().prepareCall(procString);
			int idx = 1;
			for (Object obj : params) {
				if (obj != null) {
					callStmt.setObject(idx, obj);
				} else {
					callStmt.setNull(idx, Types.NULL);
				}
				idx++;
			}
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			callStmt.close();
			session.close();
		}
	}

}
