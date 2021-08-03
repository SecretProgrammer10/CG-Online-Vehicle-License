package com.capgemini.onlinevehiclelicense.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Users")
public class Users {
	@Id
	@Column(name="email")
	@NotEmpty(message = "Email cannot be empty")
	@Pattern(regexp="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message="Email Not Valid") ///^(([^<>()[\\]\\\\.,;:\\s@\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/
	private String email;
	
	@Column(name="username")
	@Pattern(regexp="^[A-Za-z]\\\\w{5, 29}$", message="Username invalid")
	@NotEmpty(message = "Username cannot be empty")
	private String username;
	
	@Column(name="password")
	@Pattern(regexp="(?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[@#$%]).{8,20}", message="Password Not Valid") //^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$
	@NotEmpty(message = "Password cannot be empty")
	private String password;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")
	private Applicant applicant;
	
	/**
	 * 
	 */
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param email
	 * @param username
	 * @param password
	 */
	public Users(
			@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Email Not Valid") String email,
			@Pattern(regexp = "^[A-Za-z]\\\\w{5, 29}$", message = "Username invalid") String username,
			@Pattern(regexp = "(?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[@#$%]).{8,20}", message = "Password Not Valid") String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}

	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Users [getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getUsername()="
				+ getUsername() +"]";
	}
	
}