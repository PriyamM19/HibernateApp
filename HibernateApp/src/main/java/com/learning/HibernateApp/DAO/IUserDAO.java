package com.learning.HibernateApp.DAO;

import java.util.List;

import org.springframework.stereotype.Component;


import com.learning.HibernateApp.Models.UserModel;



public interface IUserDAO
{

	boolean addUser(UserModel userModel);

	List<UserModel> getAllUsers();
	
	
	
}

