package com.capgemini.onlinevehiclelicense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.model.TemporaryAddress;

@Repository
public interface ITemporaryAddressRepository extends JpaRepository<TemporaryAddress, String > {
	
	//@Query("select l from Address l where l.application_number=?1 and l.type = ?2")
	//public Address viewAddressByType(Applicant appl, String type);
}
