package com.capgemini.onlinevehiclelicense.model;

public class RTOOffice {
	private int rtoId;
	private String rtoName;
	public RTOOffice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RTOOffice(int rtoId, String rtoName) {
		super();
		this.rtoId = rtoId;
		this.rtoName = rtoName;
	}
	public int getRtoId() {
		return rtoId;
	}
	public void setRtoId(int rtoId) {
		this.rtoId = rtoId;
	}
	public String getRtoName() {
		return rtoName;
	}
	public void setRtoName(String rtoName) {
		this.rtoName = rtoName;
	}
}
