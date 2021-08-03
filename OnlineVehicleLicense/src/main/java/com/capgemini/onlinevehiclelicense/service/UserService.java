package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.mail.IMailService;
import com.capgemini.onlinevehiclelicense.mail.mailService;
import com.capgemini.onlinevehiclelicense.model.Users;
import com.capgemini.onlinevehiclelicense.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	IMailService mailService;
	
	@Override
	public ResponseEntity<Users> userRegistration(Users user)
	{
		Optional<Users> findUser = userRepo.findById(user.getEmail());
		try {
			if(!findUser.isPresent())
			{
				userRepo.save(user);
				return new ResponseEntity<Users>(HttpStatus.OK);
			}
			else
			{
				throw new RecordAlreadyPresentException("This email is already in use");
			}
		}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<Users>(HttpStatus.ALREADY_REPORTED);
		}
	}

	@Override
	public ResponseEntity<Users> userLogin(String email, String pass) {
		Optional<Users> findUser = this.userRepo.findById(email);
		try {
			if(findUser.isPresent())
			{
				if(findUser.get().getPassword().equals(pass)) {
					System.out.println("Logged In");
					return new ResponseEntity<Users>(HttpStatus.OK);
				}
				else {
					throw new RecordNotFoundException("Invlaid Password!!!");
				}
			}
			else
			{
				throw new RecordNotFoundException("Invalid email");
			}
		}
		catch(RecordNotFoundException e)
		{
			System.out.println("Error!!");
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Users> changePassword(Users user) {
		Optional<Users> findUser = userRepo.findById(user.getEmail());
		try {
			if(findUser.isPresent())
			{
				userRepo.save(user);
				return new ResponseEntity<Users>(HttpStatus.OK);
			}
			else
			{
				throw new RecordNotFoundException("Email not found");
			}
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
	}

	
	@Override
	public ResponseEntity<Users> forgotPassword(Users user, String pass) {
		Users findUser;
		try {
			findUser = userRepo.findById(user.getEmail())
					.orElseThrow(() -> new RecordNotFoundException("Email not found"));
			boolean checkOTP = sendOtp(findUser.getEmail());
			if(checkOTP) {
				findUser.setPassword(pass);
			}
			return new ResponseEntity<Users>(HttpStatus.OK);
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public String generateOtp() {
		int min = 100000;  
		int max = 999999;  
		//Generate random int value from 200 to 400   
		int b = (int)(Math.random()*(max-min+1)+min);  
		return String.valueOf(b);
	}

	@Override
	public boolean sendOtp(String toAddress) {
		String otp = generateOtp();
		String subject = "OTP for Changing Password";
		String message = "Your OTP for Re-Setting Password is: " + otp;
		mailService.sendNormalMail(toAddress, subject, message);
		return true;
	}
}
