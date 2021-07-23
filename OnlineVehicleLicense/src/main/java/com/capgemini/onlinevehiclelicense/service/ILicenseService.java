package com.capgemini.onlinevehiclelicense.service;

import java.util.List;

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.model.Documents;

public interface ILicenseService {

	public String applyForLL(Application llApplication);
	public String applyForDL(Application dlApplication);
	public String uploadDocuments(Documents documents);
	public String payFees(int amount);
	public String emailFeesReceipt(String email);
	public String bookSlotLLTest(Appointment appointment);
	public String bookSlotDLTest(Appointment appointment);
	public List<Appointment> getAvailableSlots();
	public String renewLL(Application llApplication);
	public String renewDL(Application dlApplication);
	public String cancelAppointment(Appointment appointment);
	
}
