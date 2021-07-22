package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

public class Applicant {
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String placeOfBirth;
	private String qualification;
	private String mobile;
	private String email;
	private String nationality;
	private String vehicleType;
	private String vehicleNumber;
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
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
}
