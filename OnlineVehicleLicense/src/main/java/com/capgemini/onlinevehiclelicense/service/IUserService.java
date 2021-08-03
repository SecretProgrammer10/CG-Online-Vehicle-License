package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Users;

public interface IUserService {
	public ResponseEntity<Users> userRegistration(Users user);
	public ResponseEntity<Users> userLogin(String email, String pass);
	public ResponseEntity<Users> changePassword(Users user);
	public ResponseEntity<Users> forgotPassword(Users user, String pass);
	public boolean sendOtp(String toAddress);
	
}