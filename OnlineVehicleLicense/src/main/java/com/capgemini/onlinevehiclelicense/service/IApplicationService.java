package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Application;

public interface IApplicationService {
	
	public ResponseEntity<String> createApplication(int rtoId, String username,Application application);
	public Application viewApplicationById(String applicationNumber);
//	public ResponseEntity<String> updateApplication(Application application, String applicationNumber);
	public ResponseEntity<String> deleteApplicationById(String applicationNumber);
	public String checkModeOfPayment(String applicationNumber);
	public ResponseEntity<String> payAmount(String applicationNumber, Double amountPaid);
	public String viewPaymentStatus(String applicationNumber);
	public Application viewLLApplicationById(String username);
	public Application viewDLApplicationById(String username);
	
}