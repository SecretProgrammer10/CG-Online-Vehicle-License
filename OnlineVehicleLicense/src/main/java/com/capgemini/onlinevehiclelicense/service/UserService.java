package com.capgemini.onlinevehiclelicense.service;

import com.capgemini.onlinevehiclelicense.model.User;

public interface UserService {
	public String userRegistration(User user);
	public String userLogin(User user);
	public String changePassword(User user);
	public String forgotPassword(User user);
	public String generateOtp();
	public String sendOtp();
}