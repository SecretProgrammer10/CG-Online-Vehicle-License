package com.capgemini.onlinevehiclelicense.mail;

public interface IMailService {

	public Object sendNormalMail(String to, 
			String subject, String message);
	public Object sendMailWithAttachment(String to, String subject, 
			String message, String attachement);
	
}