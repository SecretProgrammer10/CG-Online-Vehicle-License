package com.capgemini.onlinevehiclelicense.model;

public class RTOOffice {
	int rtoId;
	String rtoName;
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
	public String getRtoName() {
		return rtoName;
	}
}
