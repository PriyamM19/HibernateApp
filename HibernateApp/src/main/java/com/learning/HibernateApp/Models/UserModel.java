package com.learning.HibernateApp.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.TrueFalseType;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name= "HibernateInfo")

public class UserModel 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String userAddr;
	
	@Column(unique = true, name = "emailId")
	private String userMail;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(int userId, String userName, String userAddr, String userMail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddr = userAddr;
		this.userMail = userMail;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName + ", userAddr=" + userAddr + ", userMail="
				+ userMail + "]";
	}

	
	
	
}