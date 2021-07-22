package com.capgemini.onlinevehiclelicense.model;

public class Documents {
	private String photo;
	private String idProof;
	private String addressProof;
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
}
