package com.capgemini.onlinevehiclelicense.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

//import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Users;

public interface IUserService {
	public ResponseEntity<String> userRegistration(Users user);
	public ResponseEntity<Users> userLogin(String email, String pass);
	public ResponseEntity<String> changePassword(String email, String pass, String newPass);
	public ResponseEntity<Users> forgotPassword(String email, String pass);
	public Page<Users> getAllUsers(Pageable pageable);
	public Users getUserByEmail(String email);
	public Users getUserById(String username);
	public boolean sendOtp(String toAddress);
	
}