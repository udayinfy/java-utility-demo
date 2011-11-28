package demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import demo.dao.UserDao;
import demo.model.User;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public void createTable() {

		String createSql = "create table admin ( ID number(10) primary key, NAME varchar2(64), PASSWORD varchar2(64) )";

		jdbcTemplate.execute(createSql);

	}

	@Override
	public void insertData() {

		String insertSql1 = "insert into admin values(1, 'adm', '123456')";
		String insertSql2 = "insert into admin values(2, 'admin', '123456')";
		String insertSql3 = "insert into admin values(3, 'admin', '123456')";

		jdbcTemplate.execute(insertSql1);
		jdbcTemplate.execute(insertSql2);
		jdbcTemplate.execute(insertSql3);

	}

	@Override
	public void deleteData() {
		String deleteSql = "delete from admin where id = 2";
		jdbcTemplate.execute(deleteSql);
	}

	@Override
	public void updateData() {

		String updateSql = "update admin set name='admin1' where id=1";
		jdbcTemplate.update(updateSql);

	}

	@Override
	public User queryById(String id) {

		String sql = "select * from admin where id=?";
		final User user = new User();
		final Object[] params = new Object[] { id };

		jdbcTemplate.query(sql, params, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPassword(rs.getString("PASSWORD"));

			}

		});

		return user;

	}

	@Override
	public List<User> queryList() {

		String sql = "select * from admin";

		List<User> userList = jdbcTemplate.query(sql, new UserRowMapper());

		return userList;

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int index) throws SQLException {
			User user = new User();
			user.setId(rs.getString("ID"));
			user.setName(rs.getString("NAME"));
			user.setPassword(rs.getString("PASSWORD"));
			return user;
		}

	}

}
