package com.capgemini.onlinevehiclelicense.repository;

import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.RTOOffice;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface IRTOOfficeRepository extends JpaRepository<RTOOffice,Integer> {

	@Query("select r from RTOOffice r where r.rtoName like ?1")
	public RTOOffice getRtoId(String rtoName);

}
