package com.appserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appserver.dao.UserDao;
import com.appserver.model.User;
import com.appserver.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		User u = userDao.findUserByUserName(user.getUserName());
		if (u.getId() == 0) {
			userDao.register(user);
			return true;
		} else {
			System.out.println(String.format("[id:%s, userName:%s, password:%s]", user.getId(), user.getUserName(), user.getPassword()));
			return false;
		}
	}

	@Override
	public User loginCheck(User user) {
		// TODO Auto-generated method stub
		User u = userDao.findUserByUserName(user.getUserName());
		System.out.println(String.format("[id:%s, userName:%s, password:%s]", u.getId(), u.getUserName(), u.getPassword()));
		if (u.getPassword().equals(user.getPassword())) {
			return u;
		} else {
			return null;
		}
	}

}
