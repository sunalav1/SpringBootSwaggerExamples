package com.ibm.userrestapi.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.userrestapi.dao.UserDao;
import com.ibm.userrestapi.entity.User;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	public User getUserById(long userId) {

		return userDao.selectUserById(userId);
	}

	public void addUser(User user) {
		userDao.insertUser(user);
	}

	public void modifyUser(User user) {
		userDao.updateUser(user);
	}

	public List<User> getAllUser() {
		return userDao.selectAllUser();

	}

	public void removeUser(long userId) {
		userDao.deleteUser(userId);

	}

}
