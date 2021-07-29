package com.capgemini.onlinevehiclelicense.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="RTO_Officer")
public class RTOOfficer {
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rto_id")
	private RTOOffice rtoffice;
	
	
	@Id
	@Column(name="username")
	@Pattern(regexp="^[A-Za-z]\\\\w{5, 29}$",message="invalid user name")
	private String username;
	
	@Column(name="password")
	@NotEmpty(message="password is required")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$",message="password is invalid")
	private String password;
	
	@Column(name="email")
	@NotEmpty(message="email is required")
	@Pattern(regexp="/^(([^<>()[\\]\\\\.,;:\\s@\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/",
					message="email not valid")
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
	
	public RTOOffice getRtoffice() {
		return rtoffice;
	}
	public void setRtoffice(RTOOffice rtoffice) {
		this.rtoffice = rtoffice;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "RTOOfficer [rtoffice=" + rtoffice + ", username=" + username + ", password=" + password + ", email="
				+ email + ", getRtoffice()=" + getRtoffice() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
