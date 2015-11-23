package com.appserver.dao;

import com.appserver.model.User;

public interface UserDao {
	
	public void register(User user);
	public User findUserByUserName(String userName);

}
