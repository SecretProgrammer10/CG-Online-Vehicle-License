package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Application;

public interface IApplicationService {
	
	public ResponseEntity<Application> createApplication(Application application);
	public String viewApplicationById(String applicationNumber);
	public ResponseEntity<Application> updateApplication(Application application);
	public ResponseEntity<Application> deleteApplicationById(String applicationNumber);
	public String checkModeOfPayment(String applicationNumber);
	public ResponseEntity<Application> payAmount(String applicationNumber, Double amountPaid);
	public String viewPaymentStatus(String applicationNumber);
}