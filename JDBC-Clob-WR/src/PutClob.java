

import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.sql.CLOB;


/**
 * 插入Clob数据
 */
public class PutClob {

	public static void main(String[] args) {

		final String Webserver = "localhost";// WEB服务器IP地址
		final String SID = "orcl";// WEB数据库服务器SID
		final String UserID = "scott";// 数据库用户名
		final String Password = "tiger";// 数据库密码
		final String sDBDriver = "oracle.jdbc.driver.OracleDriver";
		
		String sConnStr = "jdbc:oracle:thin:@" + Webserver + ":1521:" + SID;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(sDBDriver);
			conn = DriverManager.getConnection(sConnStr, UserID, Password);
			conn.setAutoCommit(false);
			String sql = "select * from fileinfo where fileid=1 for update";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("开始操作clob存入:");
			
			while (rs.next()) {
				String str = "开始向表clob字段中存入数据";
				PutClob g = new PutClob();
				CLOB clob = (oracle.sql.CLOB) rs.getClob("filecontent");
				Writer outstream = clob.getCharacterOutputStream();
				outstream.write(str, 0, str.length());
				outstream.close();
				stmt.execute("commit");
				System.out.println("完毕:");
			}
			
			conn.setAutoCommit(true);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}



