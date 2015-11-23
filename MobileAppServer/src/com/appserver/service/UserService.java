package com.appserver.service;

import com.appserver.model.User;

public interface UserService {
	
	public boolean register(User user);
	public User loginCheck(User user);

}
