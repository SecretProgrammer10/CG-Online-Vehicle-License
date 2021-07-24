package com.capgemini.onlinevehiclelicense.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.model.Documents;
import com.capgemini.onlinevehiclelicense.model.License;

@Repository
public interface ILicenseRepository extends JpaRepository<License, String> {

	public String createLLRequest(Application llApplication);
	public String createDLRequest(Application dlApplication);
	public String saveDocuments(Documents documents);
	public String payFees(int amount);
	public String updateSlotLLTest(Appointment appointment);
	public String updateSlotDLTest(Appointment appointment);
	public List<Appointment> readAvailableSlots();
	public String updateLL(Appointment llAppointment);
	public String updateDL(Appointment dlAppointment);
	public String cancelAppointment(Appointment appointment);
	
}
