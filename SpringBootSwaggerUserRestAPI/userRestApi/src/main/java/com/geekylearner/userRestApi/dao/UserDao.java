package com.geekylearner.userRestApi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.geekylearner.userRestApi.entity.User;

@Repository("userDao")
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public User selectUserById(long userId) {
		return entityManager.find(User.class, userId);
	}

	public void insertUser(User user) {
		entityManager.persist(user);
	}

	public void updateUser(User user) {

		User userToUpdate = selectUserById(user.getUserId());

		userToUpdate.setUserName(user.getUserName());
		userToUpdate.setUserEmail(user.getUserEmail());
		userToUpdate.setUserPhoneNo(user.getUserPhoneNo());
		userToUpdate.setUserDob(user.getUserDob());
		entityManager.flush();
	}

	public void deleteUser(long userId) {
		entityManager.remove(selectUserById(userId));
	}

	public List<User> selectAllUser() {
		Query query = entityManager.createQuery("from User as usr order by usr.userId");
		
		List<User> userList=query.getResultList();
		System.out.println(userList.get(0).getUserId()+ userList.get(0).getUserName());
		return (List<User>) query.getResultList();
	}

}
