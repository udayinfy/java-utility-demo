package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	// ���ݿ���������
	private final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	// ���ݿ����ӵ�ַ
	private final String DBURL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	// ���ݿ��û���
	private final String DBUSER = "scott";
	// ���ݿ���������
	private final String DBPASSWORD = "tiger";
	// ����һ�����ݿ����Ӷ���
	private Connection conn = null;

	// �ڹ��췽��֮���������ݿ�
	public DataBaseConnection() {
		try {
			// ������������
			Class.forName(DBDRIVER);

			// �������ݿ�
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// ����һ�����ݿ�����
	public Connection getConnection() {
		// �������Ӷ���
		return this.conn;
	}

	// �ر����ݿ�����
	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		DataBaseConnection dbconn = new DataBaseConnection();
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








