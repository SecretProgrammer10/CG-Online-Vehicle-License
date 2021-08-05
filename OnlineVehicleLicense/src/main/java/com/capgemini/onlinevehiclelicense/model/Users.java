package com.capgemini.onlinevehiclelicense.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Users")
public class Users {
	
	@Id
	@Column(name="username")
	@ApiModelProperty(notes = "Username of the user", example = "Dibyendu_12")
	@Pattern(regexp="^[a-zA-Z0-9\\._\\-]{6,20}$", message="Username invalid")
	@NotEmpty(message = "Username cannot be empty")
	private String username;
	
	@Column(name="email",unique = true)
	@ApiModelProperty(notes = "Email address of the user", example = "dibyenduganguly.48@gmail.com")
	@Email(message = "Email Address")
	@NotEmpty(message = "Email cannot be empty")
	@Pattern(regexp="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message="Email Not Valid") ///^(([^<>()[\\]\\\\.,;:\\s@\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/
	private String email;
	
	@Column(name="password")
	@ApiModelProperty(notes = "Password of the user", example = "Dibyendu@1234")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message="Password Not Valid") //^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$
	@NotEmpty(message = "Password cannot be empty")
	private String password;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")
	@PrimaryKeyJoinColumn
	@JsonIgnore
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
			@NotEmpty(message = "Email cannot be empty") @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Email Not Valid") String email,
			@Pattern(regexp = "^[A-Za-z]\\\\w{5, 29}$", message = "Username invalid") @NotEmpty(message = "Username cannot be empty") String username,
			@Pattern(regexp = "(?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[@#$%]).{8,20}", message = "Password Not Valid") @NotEmpty(message = "Password cannot be empty") String password) {
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

	/**
	 * @return the applicant
	 */
	public Applicant getApplicant() {
		return applicant;
	}

	/**
	 * @param applicant the applicant to set
	 */
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
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
		if (applicant == null) {
			if (other.applicant != null)
				return false;
		} else if (!applicant.equals(other.applicant))
			return false;
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
		return "Users [email=" + email + ", username=" + username + ", password=" + password + ", applicant="
				+ applicant + "]";
	}
	
	

	
}