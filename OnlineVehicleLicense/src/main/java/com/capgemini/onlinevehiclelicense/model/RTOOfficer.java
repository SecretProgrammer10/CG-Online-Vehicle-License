package com.capgemini.onlinevehiclelicense.model;

public class RTOOfficer {
	String username;
	String password;
	String email;
	public RTOOfficer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RTOOfficer(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
}
