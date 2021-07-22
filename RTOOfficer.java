package com.capgemini.onlinevehiclelicense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RTO_Officer")
public class RTOOfficer {
	
	@Id
	@Column(name="rto_id")
	int Id;
	private String username;
	private String password;
	private String email;
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
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
