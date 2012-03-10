package demo.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleJdbcConnection {

	// 数据库驱动程序
	private final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	// 数据库连接地址
	private final String DBURL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	// 数据库用户名
	private final String DBUSER = "scott";
	// 数据库连接密码
	private final String DBPASSWORD = "tiger";
	// 声明一个数据库连接对象
	private Connection conn = null;

	// 在构造方法之中连接数据库
	public OracleJdbcConnection() {
		try {
			// 加载驱动程序
			Class.forName(DBDRIVER);

			// 连接数据库
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// 返回一个数据库连接
	public Connection getConnection() {
		// 返回连接对象
		return this.conn;
	}

	// 关闭数据库连接
	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		OracleJdbcConnection dbconn = new OracleJdbcConnection();
		Connection conn = dbconn.getConnection();
		
		Statement stmt = null;
		ResultSet rs  = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from emp");
			
			int count = 0;
			while( rs.next() ) {
				int empNo = rs.getInt("empno");
				String eName = rs.getString("ename");
				
				count++;
				System.out.println( empNo + ":" + eName);
			}
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null )
					rs.close();
				if( stmt != null )
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}








