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
	
	//@Id
	@Column(name = "id_proof")
	@NotEmpty(message="id proof should not be empty")
	private String idProof;
	
	@Column(name = "address_proof")
	@NotEmpty(message="address proof should not be empty")
	private String addressProof;

	
	public Documents() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param application
	 * @param photo
	 * @param idProof
	 * @param addressProof
	 */
	public Documents(Application application, @NotEmpty(message = "photo should not be empty") String photo,
			@NotEmpty(message = "id proof should not be empty") String idProof,
			@NotEmpty(message = "address proof should not be empty") String addressProof) {
		super();
		this.application = application;
		this.photo = photo;
		this.idProof = idProof;
		this.addressProof = addressProof;
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

	@Override
	public String toString() {
		return "Documents [application=" + application + ", photo=" + photo + ", idProof=" + idProof + ", addressProof="
				+ addressProof + "]";
	}



	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

	
}
