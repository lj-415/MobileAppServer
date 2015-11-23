package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.appserver.dao.UserDao;
import com.appserver.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user(userName,password) values(?,?)";
		Object[] params = new Object[] { user.getUserName(), user.getPassword() };
		jdbcTemplate.update(sql, params);
	}

	@Override
	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		final User user = new User();
		String sql = "select * from user where userName=?";
		jdbcTemplate.query(sql, new Object[] { userName }, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
			}
		});
		return user;
	}

}
