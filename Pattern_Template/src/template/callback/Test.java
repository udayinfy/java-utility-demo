package template.callback;

import java.sql.ResultSet;

public class Test {
	
	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "select * from table";
		final Object obj = new Object();
		jdbcTemplate.query(sql, new JdbcCallBack() {
			
			@Override
			public void resultMapping(ResultSet rs) {
				// TODO Auto-generated method stub
				// rs mapping obj
			}
		});
	}

}
