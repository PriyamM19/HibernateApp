package com.learning.HibernateApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.HibernateApp.DAO.IUserDAO;
import com.learning.HibernateApp.Models.UserModel;


@Controller
public class UserController
{

	@Autowired
	UserModel userModel;
	
	@Autowired
	IUserDAO userDao;
	
	
	@RequestMapping("/")
	public ModelAndView index()
	{
		
		  List<UserModel> userList = userDao.getAllUsers();
		 
		 ModelAndView mv = new ModelAndView();
		  mv.addObject("userData", userList);
		  mv.setViewName("index");
		 
		return mv;
		
		
	}
	
	@RequestMapping("/createData")
	public String createData()
	{
		
		userModel.setUserName("Priyam");
		userModel.setUserAddr("Andheri(E)");
		userModel.setUserMail("priyam1911@gmail.com");
		
	
		boolean isSaved=userDao.addUser(userModel);
		if (isSaved)
		{
			return "redirect:/";
			
		}
		return "Data Insertion Failed";
		


		
		
	}
	
	
}
