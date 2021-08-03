package com.capgemini.onlinevehiclelicense.model;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Documents")
public class Documents {
	//@OneToOne(cascade = CascadeType.ALL)
	@Id
	@Column(name = "application_id")
	private String id;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "application_number")
	private Application application;
	
	@Column(name = "photo")
	@NotEmpty(message="photo should not be empty")
	private String photo;
	
	@Column(name = "id_proof")
	@NotEmpty(message="id proof should not be empty")
	private String idProof;
	
	@Column(name = "address_proof")
	@NotEmpty(message="address proof should not be empty")
	private String addressProof;

	/**
	 * 
	 */
	public Documents() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param photo
	 * @param idProof
	 * @param addressProof
	 */
	public Documents(String id, @NotEmpty(message = "photo should not be empty") String photo,
			@NotEmpty(message = "id proof should not be empty") String idProof,
			@NotEmpty(message = "address proof should not be empty") String addressProof) {
		super();
		this.id = id;
		this.photo = photo;
		this.idProof = idProof;
		this.addressProof = addressProof;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the application
	 */
	public Application getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(Application application) {
		this.application = application;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the idProof
	 */
	public String getIdProof() {
		return idProof;
	}

	/**
	 * @param idProof the idProof to set
	 */
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	/**
	 * @return the addressProof
	 */
	public String getAddressProof() {
		return addressProof;
	}

	/**
	 * @param addressProof the addressProof to set
	 */
	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressProof == null) ? 0 : addressProof.hashCode());
		result = prime * result + ((application == null) ? 0 : application.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idProof == null) ? 0 : idProof.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
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
		Documents other = (Documents) obj;
		if (addressProof == null) {
			if (other.addressProof != null)
				return false;
		} else if (!addressProof.equals(other.addressProof))
			return false;
		if (application == null) {
			if (other.application != null)
				return false;
		} else if (!application.equals(other.application))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idProof == null) {
			if (other.idProof != null)
				return false;
		} else if (!idProof.equals(other.idProof))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Documents [id=" + id + ", application=" + application + ", photo=" + photo + ", idProof=" + idProof
				+ ", addressProof=" + addressProof + "]";
	}
	
	
}
