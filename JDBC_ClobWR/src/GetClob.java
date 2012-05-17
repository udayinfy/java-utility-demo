

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.sql.CLOB;

/**
 * 读取Clob书数据
 */
public class GetClob {

	public String getClob(ResultSet rs, String colname) throws Exception {
		try {
			CLOB clob = (oracle.sql.CLOB) rs.getClob(colname);
			Reader instream = clob.getCharacterStream();
			char[] buffer = new char[1000];
			int length = 0;
			String Str = "";
			while ((length = instream.read(buffer)) != -1) {
				Str = Str + new String(buffer, 0, length);
			}
			instream.close();
			return Str;
		} catch (Exception e) {
			System.out.println("opendb.getClob():" + e.getMessage());
			return "";
		}
	}

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
			String sql = "select fileid,filename,filecontent from fileinfo";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getString("filename"));
				GetClob g = new GetClob();
				System.out.println("测试clob字段值:" + g.getClob(rs, "filecontent"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}



