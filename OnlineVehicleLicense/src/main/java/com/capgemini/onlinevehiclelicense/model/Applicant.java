package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

public class Applicant {
	String firstName;
	String middleName;
	String lastName;
	Date dateOfBirth;
	String placeOfBirth;
	String qualification;
	String mobile;
	String email;
	String nationality;
	String vehicleType;
	String vehicleNumber;
	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Applicant(String firstName, String middleName, String lastName, Date dateOfBirth, String placeOfBirth,
			String qualification, String mobile, String email, String nationality, String vehicleType,
			String vehicleNumber) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.qualification = qualification;
		this.mobile = mobile;
		this.email = email;
		this.nationality = nationality;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public String getQualification() {
		return qualification;
	}
	public String getMobile() {
		return mobile;
	}
	public String getEmail() {
		return email;
	}
	public String getNationality() {
		return nationality;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
}
