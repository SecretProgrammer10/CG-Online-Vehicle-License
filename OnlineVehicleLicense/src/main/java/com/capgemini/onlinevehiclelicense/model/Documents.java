package com.capgemini.onlinevehiclelicense.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Documents")
public class Documents {
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "application_number")
	
	@Id
	@Column(name = "application_number")
	private String applicationNumber;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "id_proof")
	private String idProof;
	
	@Column(name = "address_proof")
	private String addressProof;

	
	public Documents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Documents(String applicationNumber, String photo, String idProof, String addressProof) {
		super();
		this.applicationNumber = applicationNumber;
		this.photo = photo;
		this.idProof = idProof;
		this.addressProof = addressProof;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

	@Override
	public String toString() {
		return "Documents [applicationNumber=" + applicationNumber + ", photo=" + photo + ", idProof=" + idProof
				+ ", addressProof=" + addressProof + "]";
	}
}