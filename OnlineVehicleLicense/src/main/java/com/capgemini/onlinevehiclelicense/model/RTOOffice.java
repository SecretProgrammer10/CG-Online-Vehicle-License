package com.capgemini.onlinevehiclelicense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="Rtooffice")

public class RTOOffice {
	
	@Id
	@Column(name="rto_id")
	private int rtoId;
	
	
	@Column(name="rto_name")
	@NotEmpty(message="rtoName is required")
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
	//@Column(name="RtoID")
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
	@Override
	public String toString() {
		return "RTOOffice [rtoId=" + rtoId + ", rtoName=" + rtoName + ", getRtoId()=" + getRtoId() + ", getRtoName()="
				+ getRtoName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
