package template.callback;

import java.sql.ResultSet;

public class JdbcTemplate {
	
	
	
	public void query(String sql, JdbcCallBack callBack){
		
		// con.execute(sql)
		ResultSet rs = null;
		
		callBack.resultMapping(rs);
		
		// con.close()
		
	}

}
