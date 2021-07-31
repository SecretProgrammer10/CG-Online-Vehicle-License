package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Users;

public interface IUserService {
	public ResponseEntity<Users> userRegistration(Users user);
	public ResponseEntity<Users> userLogin(Users user);
	public ResponseEntity<Users> changePassword(Users user);
	public String forgotPassword(Users user);
	public String generateOtp();
	public String sendOtp();
}