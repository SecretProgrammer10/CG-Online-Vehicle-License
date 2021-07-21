package com.capgemini.onlinevehiclelicense.model;

public class User {
	String email;
	String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String email, String password)
	{
		this.email=email;
		this.password=password;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPassword()
	{
		return password;
	}
}
