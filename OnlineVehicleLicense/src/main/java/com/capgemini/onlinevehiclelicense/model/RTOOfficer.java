package com.capgemini.onlinevehiclelicense.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Rtoofficer")
public class RTOOfficer {
	
	@Id
	@Column(name="username")
	@ApiModelProperty(notes="Username",example="Nil@12345")
	@Pattern(regexp="^[a-zA-Z0-9\\._\\-]{6,20}$",message="invalid user name")
	private String username;
	
	@Column(name="password")
	@ApiModelProperty(notes="Username",example="Nil_1234")
	@NotEmpty(message="password is required")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message="password is invalid")
	private String password;
	
	@Column(name="email")
	@ApiModelProperty(notes="Username",example="nil@gmail.com")
	@NotEmpty(message="email is required")
	@Pattern(regexp="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",message="email not valid")
	private String email;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "rto_office_name", nullable=false)
	@JsonIgnore
	private RTOOffice rtoOffice;

	/**
	 * 
	 */
	public RTOOfficer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param password
	 * @param email
	 */
	public RTOOfficer(@Pattern(regexp = "^[a-zA-Z0-9\\._\\-]{6,20}$", message = "invalid user name") String username,
			@NotEmpty(message = "password is required") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "password is invalid") String password,
			@NotEmpty(message = "email is required") @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "email not valid") String email) {
		super();
		this.username = username;
		this.password = password;
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
	 * @return the rtoOffice
	 */
	public RTOOffice getRtoOffice() {
		return rtoOffice;
	}

	/**
	 * @param rtoOffice the rtoOffice to set
	 */
	public void setRtoOffice(RTOOffice rtoOffice) {
		this.rtoOffice = rtoOffice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((rtoOffice == null) ? 0 : rtoOffice.hashCode());
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
		RTOOfficer other = (RTOOfficer) obj;
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
		if (rtoOffice == null) {
			if (other.rtoOffice != null)
				return false;
		} else if (!rtoOffice.equals(other.rtoOffice))
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
		return "RTOOfficer [username=" + username + ", password=" + password + ", email=" + email + ", rtoOffice=" + rtoOffice + "]";
	}
	
	
	
	
}
