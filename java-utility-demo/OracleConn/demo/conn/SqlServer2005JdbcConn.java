package demo.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlServer2005JdbcConn {

	// 数据库驱动程序
	private final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// 数据库连接地址
	private final String DB_URL = "jdbc:sqlserver://10.2.13.54:1433;DatabaseName=dcm";
	// 数据库用户名
	private final String DB_USER = "sa";
	// 数据库连接密码
	private final String DB_PASSWORD = "123456";
	// 声明一个数据库连接对象
	private Connection conn = null;

	// 在构造方法之中连接数据库
	public SqlServer2005JdbcConn() {
		try {
			// 加载驱动程序
			Class.forName(DB_DRIVER);

			// 连接数据库
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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
		
		SqlServer2005JdbcConn dbconn = new SqlServer2005JdbcConn();
		Connection conn = dbconn.getConnection();
		
		Statement stmt = null;
		ResultSet rs  = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(" select * from users where userid = 2 ");
			
			while( rs.next() ) {
				String password = rs.getString("password");
				System.out.println(password);
				
			}
			
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








