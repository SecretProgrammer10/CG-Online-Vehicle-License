package com.capgemini.onlinevehiclelicense.service;

import com.capgemini.onlinevehiclelicense.model.Application;

public interface IApplicationService {
	
	public String createApplication(Application app_number);
	public String viewApplication(Application app_number);
	public String updateApplication(Application app_number);
	public String deleteApplication(Application app_number);
	public String checkModeOfPayment(String payment);
	public String payAmount(int amount);
	public String viewPaymentStatus(String payment_status);
}
