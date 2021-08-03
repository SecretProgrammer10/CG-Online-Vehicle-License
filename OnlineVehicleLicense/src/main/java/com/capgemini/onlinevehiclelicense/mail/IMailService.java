package com.capgemini.onlinevehiclelicense.mail;

public interface IMailService {

	public void sendNormalMail(String to, 
			String subject, String message);
	public void sendMailWithAttachement(String to, String subject, 
			String message, String attachement);
	
}