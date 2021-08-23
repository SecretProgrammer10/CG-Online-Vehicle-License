package com.capgemini.onlinevehiclelicense.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;



@Entity
@Table(name = "address")
public class Address {

	@Id
	/*@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_seq")
	@SequenceGenerator(name="address_seq",sequenceName="address_seq", allocationSize=1)*/
	@Column(name="address_id")
	@JsonIgnore
	private String addrId;
	
	@NotNull(message = "House cannot be null")
	@Size(min = 10, max = 200, message 
		      = "Address must be between 10 and 200 characters")
	@ApiModelProperty(notes = "House address with house name", example = "Mannat, Land’s End, Byramji Jeejeebhoy Road, Bandra (West)")
	@Column(name="house")
	private String house;
	
	@ApiModelProperty(notes = "Landmark", example = "Bandstand")
	@Column(name="landmark")
	private String landmark;
	
	@NotNull(message = "City cannot be null")
	@ApiModelProperty(notes = "Name of city", example = "Mumbai")
	@Column(name="city")
	private String city;
	
	@NotNull(message = "State cannot be null")
	@ApiModelProperty(notes = "Name of State", example = "Maharashtra")
	@Column(name="state")
	private String state;
	
	@NotNull(message = "Pincode cannot be null")
	@ApiModelProperty(notes = "Pincode", example = "400050")
	@Column(name="pincode")
	private int pincode;
	
//	@NotNull(message = "Field cannot be null")
//	@ApiModelProperty(notes = "True if present address is same as permanent address")
//	@Transient
//	private boolean isSame;
	
	//@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	//@OneToOne(cascade = CascadeType.ALL)
	//@MapsId
	//@JoinColumn(name="applicant_id")
	//private Applicant applicant;
	
	@OneToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY, optional=false)
	@MapsId
	@JoinColumn(name = "address_id", nullable = false)
	@JsonIgnore
	private Applicant applicant;
	

	/**
	 * 
	 */
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param addrId
	 * @param house
	 * @param state
	 * @param city
	 * @param landmark
	 * @param pincode
	 */
	public Address(String addrId, String house, String state, String city, String landmark, int pincode) {
		super();
		this.addrId = addrId;
		this.house = house;
		this.state = state;
		this.city = city;
		this.landmark = landmark;
		this.pincode = pincode;
	}

	/**
	 * @return the addrId
	 */
	public String getAddrId() {
		return addrId;
	}

	/**
	 * @param addrId the addrId to set
	 */
	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}

	/**
	 * @return the house
	 */
	public String getHouse() {
		return house;
	}

	/**
	 * @param house the house to set
	 */
	public void setHouse(String house) {
		this.house = house;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the landmark
	 */
	public String getLandmark() {
		return landmark;
	}

	/**
	 * @param landmark the landmark to set
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	/**
	 * @return the pincode
	 */
	public int getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(int pincode) {
		this.pincode = pincode;
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


//	/**
//	 * @return the isSame
//	 */
//	public boolean isSame() {
//		return isSame;
//	}
//
//	/**
//	 * @param isSame the isSame to set
//	 */
//	public void setSame(boolean isSame) {
//		this.isSame = isSame;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addrId == null) ? 0 : addrId.hashCode());
		result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((landmark == null) ? 0 : landmark.hashCode());
		result = prime * result + pincode;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Address other = (Address) obj;
		if (addrId == null) {
			if (other.addrId != null)
				return false;
		} else if (!addrId.equals(other.addrId))
			return false;
		if (applicant == null) {
			if (other.applicant != null)
				return false;
		} else if (!applicant.equals(other.applicant))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (landmark == null) {
			if (other.landmark != null)
				return false;
		} else if (!landmark.equals(other.landmark))
			return false;
		if (pincode != other.pincode)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", house=" + house + ", state=" + state + ", city=" + city + ", landmark="
				+ landmark + ", pincode=" + pincode + ", applicant=" + applicant + "]";
	}
	
}
