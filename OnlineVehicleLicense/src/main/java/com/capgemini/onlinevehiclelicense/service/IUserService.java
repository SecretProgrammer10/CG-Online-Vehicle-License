package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.User;

public interface IUserService {
	public ResponseEntity<User> userRegistration(User user);
	public ResponseEntity<User> userLogin(User user);
	public ResponseEntity<User> changePassword(User user);
	public String forgotPassword(User user);
	public String generateOtp();
	public String sendOtp();
}