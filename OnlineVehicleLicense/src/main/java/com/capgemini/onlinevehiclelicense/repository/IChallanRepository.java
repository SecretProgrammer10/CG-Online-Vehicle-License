package com.capgemini.onlinevehiclelicense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.Challan;

@Repository
public interface IChallanRepository extends JpaRepository<Challan, String> {

	@Query("select c from Challan c where c.vehicleNumber like ?1")
	public List<Challan> getDetailsByVehicleNumber(String vehicleNumber);
}
