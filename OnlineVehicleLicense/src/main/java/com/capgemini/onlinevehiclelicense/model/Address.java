package com.capgemini.onlinevehiclelicense.model;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
//import javax.persistence.SequenceGenerator;


@Entity
public class Address {

	@Id
	/*@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_seq")
	@SequenceGenerator(name="address_seq",sequenceName="address_seq", allocationSize=1)*/
	@Column(name="addr_id")
	private String addrId;
	@Column(name="house")
	private String house;
	@Column(name="state")
	private String state;
	@Column(name="city")
	private String city;
	@Column(name="landmark")
	private String landmark;
	@Column(name="pincode")
	private int pincode;
	//@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@OneToOne
	@MapsId
	@JoinColumn(name="applicant_id")
	private Applicant applicant;
//	@Column(name="type")
//	private String type;
	
	


	public Address() {
		super();
	}


	public Address(String addrId, String house, String state, String city, String landmark, int pincode, Applicant applicant) {
		super();
		this.addrId = addrId;
		this.house = house;
		this.state = state;
		this.city = city;
		this.landmark = landmark;
		this.pincode = pincode;
		this.applicant = applicant;
	}


	public String getAddrId() {
		return addrId;
	}


	public String getHouse() {
		return house;
	}


	public void setHouse(String house) {
		this.house = house;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	public Applicant getApplicant() {
		return applicant;
	}
	
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
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