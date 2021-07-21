package com.capgemini.onlinevehiclelicense.model;

public class Documents {
	String photo;
	String idProof;
	String addressProof;
	public Documents() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Documents(String photo, String idProof, String addressProof) {
		super();
		this.photo = photo;
		this.idProof = idProof;
		this.addressProof = addressProof;
	}
	public String getPhoto() {
		return photo;
	}
	public String getIdProof() {
		return idProof;
	}
	public String getAddressProof() {
		return addressProof;
	}
	
}
