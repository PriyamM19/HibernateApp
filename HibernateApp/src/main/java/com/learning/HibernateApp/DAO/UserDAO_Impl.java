package com.learning.HibernateApp.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.HibernateApp.Models.UserModel;



@Repository
@Transactional
public class UserDAO_Impl implements IUserDAO 
{
	
	@Autowired
	public SessionFactory sessionFactory;

	
	public boolean addUser(UserModel userModel)
	{
		sessionFactory.getCurrentSession().save(userModel);
		return true;
	}

	
	public List<UserModel> getAllUsers() {
		List<UserModel> allUsers = sessionFactory
									.getCurrentSession()
									.createQuery("from UserModel")
									.list();
		
		return allUsers;
	}

}
