package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.mail.IMailService;
import com.capgemini.onlinevehiclelicense.model.Users;
import com.capgemini.onlinevehiclelicense.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	IMailService mailService;
	
	@Override
	public ResponseEntity<String> userRegistration(Users user)
	{
		Optional<Users> findUser = userRepo.findById(user.getUsername());
		try {
			Users findUserByEmail = userRepo.getUserByEmail(user.getEmail());
			if(findUserByEmail!=null) {
				throw new RecordAlreadyPresentException("Entered email already in use");
			}
		} catch (RecordNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RecordAlreadyPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.ALREADY_REPORTED);
		}
		try {
			if(!findUser.isPresent())
			{
				userRepo.save(user);
				return new ResponseEntity<String>("Successfully created User! \nEmail: "+user.getEmail()+"\nUsername: "+user.getUsername(),HttpStatus.OK);
			}
			else
			{
				throw new RecordAlreadyPresentException("This username is already in use");
			}
		}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.ALREADY_REPORTED);
		}
	}

	@Override
	public ResponseEntity<String> userLogin(String username, String pass) {
		Optional<Users> findUser = this.userRepo.findById(username);
		try {
			if(findUser.isPresent())
			{
				if(findUser.get().getPassword().equals(pass)) {
					System.out.println("Logged In");
					return new ResponseEntity<String>("Succesfully logged in!!!",HttpStatus.OK);
				}
				else {
					throw new RecordNotFoundException("Invalid Password!!!");
				}
			}
			else
			{
				throw new RecordNotFoundException("User with username : " + username +" does not exist");
			}
		}
		catch(RecordNotFoundException e)
		{
			System.out.println("Error!!");
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<String> changePassword(String email, String pass, String newPass) {
		Users user;
		try {
			user = userRepo.getUserByEmail(email);
			if(user!=null) {
				if(user.getPassword().equals(pass)) {
					user.setPassword(newPass);
					this.userRepo.save(user);
					return new ResponseEntity<String>("Password changed successfully", HttpStatus.OK);
				}
				else {
					return new ResponseEntity<String>("Incorrect password", HttpStatus.UNAUTHORIZED);
				}
			}
			else {
				throw new RecordNotFoundException("Email does not exists");
			}
			
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Email does not exists",HttpStatus.NOT_FOUND);
		}		 
	}

	
	@Override
	public ResponseEntity<String> forgotPassword(String email, String newPass) {
		Users findUser;
		try {
			findUser = userRepo.getUserByEmail(email);
			if(userRepo != null) {
				boolean checkOTP = sendOtp(findUser.getEmail());
				if(checkOTP) {
					findUser.setPassword(newPass);
					return new ResponseEntity<String>("New Password has been set!", HttpStatus.OK);
				}
				else {
					return new ResponseEntity<String>("Incorrect OTP!", HttpStatus.UNAUTHORIZED);
				}
			}
			else {
				throw new RecordNotFoundException("No such User was found!!!");
			}
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<String>("No profile found!!!", HttpStatus.NOT_FOUND);
		}
	}

	private String generateOtp() {
		int min = 100000;  
		int max = 999999;  
		//Generate random int value from 10000 to 999999   
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

	@Override
	public Page<Users> getAllUsers(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.userRepo.findAll(pageable);
	}

	@Override
	public Users getUserById(String email) {
		// TODO Auto-generated method stub
		try {
			return this.userRepo.findById(email)
					.orElseThrow(() -> new RecordNotFoundException("This Email Id is not present"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Users getUserByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			return this.userRepo.getUserByEmail(email);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
