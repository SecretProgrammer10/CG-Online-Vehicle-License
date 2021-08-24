package com.capgemini.onlinevehiclelicense.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="Rtooffice")

public class RTOOffice {
	
	@Id
	@Column(name="rto_id")
    @GeneratedValue (strategy = GenerationType.AUTO)
	@JsonIgnore
	private int rtoId;
	
	@ApiModelProperty(notes = "RTO Office Name", example = "PUNE")
	@Column(name="rto_name")
	@NotEmpty(message="rtoName is required")
	private String rtoName;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JsonIgnore
	private Set<RTOOfficer> rtoOfficer;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Application> application;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<License> license;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JsonIgnore
	private Set<Appointment> appointment;

	/**
	 * 
	 */
	public RTOOffice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param rtoId
	 * @param rtoName
	 */
	public RTOOffice(int rtoId, @NotEmpty(message = "rtoName is required") String rtoName) {
		super();
		this.rtoId = rtoId;
		this.rtoName = rtoName;
	}

	/**
	 * @return the rtoId
	 */
	public int getRtoId() {
		return rtoId;
	}

	/**
	 * @param rtoId the rtoId to set
	 */
	public void setRtoId(int rtoId) {
		this.rtoId = rtoId;
	}
	
	/**
	 * @return the appointment
	 */
	public Set<Appointment> getAppointment() {
		return appointment;
	}

	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(Set<Appointment> appointment) {
		this.appointment = appointment;
	}

	/**
	 * @return the rtoName
	 */
	public String getRtoName() {
		return rtoName;
	}

	/**
	 * @param rtoName the rtoName to set
	 */
	public void setRtoName(String rtoName) {
		this.rtoName = rtoName;
	}

	/**
	 * @return the rtoOfficer
	 */
	public Set<RTOOfficer> getRtoOfficer() {
		return rtoOfficer;
	}

	/**
	 * @param rtoOfficer the rtoOfficer to set
	 */
	public void setRtoOfficer(Set<RTOOfficer> rtoOfficer) {
		this.rtoOfficer = rtoOfficer;
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
	 * @return the license
	 */
	public Set<License> getLicense() {
		return license;
	}

	/**
	 * @param license the license to set
	 */
	public void setLicense(Set<License> license) {
		this.license = license;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((application == null) ? 0 : application.hashCode());
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		result = prime * result + rtoId;
		result = prime * result + ((rtoName == null) ? 0 : rtoName.hashCode());
		result = prime * result + ((rtoOfficer == null) ? 0 : rtoOfficer.hashCode());
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
		RTOOffice other = (RTOOffice) obj;
		if (application == null) {
			if (other.application != null)
				return false;
		} else if (!application.equals(other.application))
			return false;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		if (rtoId != other.rtoId)
			return false;
		if (rtoName == null) {
			if (other.rtoName != null)
				return false;
		} else if (!rtoName.equals(other.rtoName))
			return false;
		if (rtoOfficer == null) {
			if (other.rtoOfficer != null)
				return false;
		} else if (!rtoOfficer.equals(other.rtoOfficer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RTOOffice [rtoId=" + rtoId + ", rtoName=" + rtoName + ", rtoOfficer=" + rtoOfficer + ", application="
				+ application + ", appointment="
						+ appointment +", license=" + license + "]";
	}
	
	
	
}
