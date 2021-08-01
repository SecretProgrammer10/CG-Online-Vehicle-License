package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Applicant")
public class Applicant {
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "email", referencedColumnName = "email")
	private Users user;
	@Id
	@Column(name="applicant_number")
	private String applicantNumber;
	@Column(name="first_name")
	private String firstName;
	@Column(name="middle_name")
	private String middleName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="dare_of_birth")
	private Date dateOfBirth;
	@Column(name="place_of_birth")
	private String placeOfBirth;
	@Column(name="qualification")
	private String qualification;
	@Column(name="mobile")
	private String mobile;
	@Column(name="nationality")
	private String nationality;
	@Column(name="vehicle_type")
	private String vehicleType;
	@Column(name="vehicle_number")
	private String vehicleNumber;
	
	@OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;
	
	@Column(name="gender")
	private String gender;
	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Applicant(String applicantNumber, String firstName, String middleName, String lastName,
			Date dateOfBirth, String placeOfBirth, String qualification, String mobile, String nationality,
			String vehicleType, String vehicleNumber, Address address, String gender) {
		super();
		this.applicantNumber = applicantNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.qualification = qualification;
		this.mobile = mobile;
		this.nationality = nationality;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
	//	this.address = address;
		this.gender = gender;
	}
	public String getApplicantNumber() {
		return applicantNumber;
	}
	public void setApplicantNumber(String applicantNumber) {
		this.applicantNumber = applicantNumber;
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
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Applicant [applicantNumber=" + applicantNumber + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", placeOfBirth="
				+ placeOfBirth + ", qualification=" + qualification + ", mobile=" + mobile + ", email=" + user.getEmail() + ", nationality="
				+ nationality + ", vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber + /*", address="
				+ address + */ ", gender=" + gender + "]";
	}
}
