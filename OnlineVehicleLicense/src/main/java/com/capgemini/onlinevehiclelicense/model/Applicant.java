package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Applicant")
public class Applicant {
	
	@Id
	@Column(name="applicant_id")
	@NotEmpty(message = "ID cannot be empty")
	
	private String applicantId;
	
	@NotNull(message = "Firstname cannot be null")
	@ApiModelProperty(notes = "Firstname", example = "Nil")
	@Column(name="first_name")
	private String firstName;
	
	@ApiModelProperty(notes = "Middlename", example = "Nitin")
	@Column(name="middle_name")
	private String middleName;
	
	@NotNull(message = "Lastname cannot be null")
	@ApiModelProperty(notes = "Lastname", example = "Mukesh")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message = "Date of birth cannot be null")
	@ApiModelProperty(notes = "Date of birth", example = "19-11-1999")
	@Column(name="date_of_birth")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dateOfBirth;
	
	@NotNull(message = "Place of birth cannot be null")
	@ApiModelProperty(notes = "Firstname", example = "Mumbai")
	@Column(name="place_of_birth")
	private String placeOfBirth;
	
	@NotNull(message = "Gender cannot be null")
	@ApiModelProperty(notes = "Firstname")
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	
	@ApiModelProperty(notes = "Firstname", example = "B.Sc")
	@Column(name="qualification")
	private String qualification;
	
	@Size(min = 10, max = 10, message 
		      = "Mobile number consists of 10 digits")
	@NotNull(message = "Mobile cannot be null")
	@ApiModelProperty(notes = "Firstname", example = "9876543210")
	@Column(name="mobile")
	private String mobile;
	
	@NotNull(message = "Nationality cannot be null")
	@ApiModelProperty(notes = "Nationality", example = "Indian")
	@Column(name="nationality")
	private String nationality;
	
	@NotNull(message = "Vehicle type cannot be null")
	@ApiModelProperty(notes = "Vehicle type")
	@Column(name="vehicle_type")
	private String vehicleType;
	
	@Size(min = 12, max = 12, message 
		      = "Vehicle number consists of 12 digits")
	@NotNull(message = "Vehicle number cannot be null")
	@ApiModelProperty(notes = "Vehicle number", example = "MH-98-654321")
	@Column(name="vehicle_number")
	private String vehicleNumber;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "applicant", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JsonIgnore
	private Address address;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "applicant", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JsonIgnore
	private TemporaryAddress tempAddress;
	
	//@OneToMany(cascade=CascadeType.ALL)
	//
	//private Set<Address> address;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Application> application;
	
	@OneToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY, optional=false)
	@MapsId
	@JoinColumn(name = "applicant_id", nullable = false)
	@JsonIgnore
	private Users users;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Challan> challan;

	/**
	 * 
	 */
	public Applicant() {
		super();
	}

	/**
	 * @param applicantId
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param dateOfBirth
	 * @param placeOfBirth
	 * @param gender
	 * @param qualification
	 * @param mobile
	 * @param nationality
	 * @param vehicleType
	 * @param vehicleNumber
	 * @param address
	 */
	public Applicant(@NotEmpty(message = "Id cannot be empty") String applicantId, String firstName, String middleName,
			String lastName, Date dateOfBirth, String placeOfBirth, Gender gender, String qualification, String mobile,
			String nationality, String vehicleType, String vehicleNumber /* , Address address */) {
		super();
		this.applicantId = applicantId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.gender = gender;
		this.qualification = qualification;
		this.mobile = mobile;
		this.nationality = nationality;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		//this.address = address;
	}

	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param dateOfBirth
	 * @param placeOfBirth
	 * @param gender
	 * @param qualification
	 * @param mobile
	 * @param nationality
	 * @param vehicleType
	 * @param vehicleNumber
	 */
	public Applicant(String firstName, String middleName, String lastName, Date dateOfBirth, String placeOfBirth,
			Gender gender, String qualification, String mobile, String nationality, String vehicleType,
			String vehicleNumber) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.gender = gender;
		this.qualification = qualification;
		this.mobile = mobile;
		this.nationality = nationality;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * @return the applicantId
	 */
	public String getApplicantId() {
		return applicantId;
	}

	/**
	 * @param applicantId the applicantId to set
	 */
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the placeOfBirth
	 */
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	/**
	 * @param placeOfBirth the placeOfBirth to set
	 */
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}

	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the vehicleNumber
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * @param vehicleNumber the vehicleNumber to set
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the application
	 */
	public Set<Application> getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(Set<Application> application) {
		this.application = application;
	}

	/**
	 * @return the users
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * @return the challan
	 */
	public Set<Challan> getChallan() {
		return challan;
	}

	/**
	 * @param challan the challan to set
	 */
	public void setChallan(Set<Challan> challan) {
		this.challan = challan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((applicantId == null) ? 0 : applicantId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + ((placeOfBirth == null) ? 0 : placeOfBirth.hashCode());
		result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + ((vehicleNumber == null) ? 0 : vehicleNumber.hashCode());
		result = prime * result + ((vehicleType == null) ? 0 : vehicleType.hashCode());
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
		Applicant other = (Applicant) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (applicantId == null) {
			if (other.applicantId != null)
				return false;
		} else if (!applicantId.equals(other.applicantId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (placeOfBirth == null) {
			if (other.placeOfBirth != null)
				return false;
		} else if (!placeOfBirth.equals(other.placeOfBirth))
			return false;
		if (qualification == null) {
			if (other.qualification != null)
				return false;
		} else if (!qualification.equals(other.qualification))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (vehicleNumber == null) {
			if (other.vehicleNumber != null)
				return false;
		} else if (!vehicleNumber.equals(other.vehicleNumber))
			return false;
		if (vehicleType == null) {
			if (other.vehicleType != null)
				return false;
		} else if (!vehicleType.equals(other.vehicleType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Applicant [getApplicantId()=" + getApplicantId() + ", getFirstName()=" + getFirstName() + ", getMiddleName()="
				+ getMiddleName() + ", getLastName()=" + getLastName() + ", getDateOfBirth()=" + getDateOfBirth()
				+ ", getPlaceOfBirth()=" + getPlaceOfBirth() + ", getGender()=" + getGender() + ", getQualification()="
				+ getQualification() + ", getMobile()=" + getMobile() + ", getNationality()=" + getNationality()
				+ ", getVehicleType()=" + getVehicleType() + ", getVehicleNumber()=" + getVehicleNumber()
				+ ", getAddress()=" + getAddress() + "]";
	}
	
	
}
