package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.User;
import com.capgemini.onlinevehiclelicense.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	IUserRepository userRepo;
	
	@Override
	public ResponseEntity<User> userRegistration(User user)
	{
		Optional<User> findUser = userRepo.findById(user.getEmail());
		try {
			if(!findUser.isPresent())
			{
				userRepo.save(user);
				return new ResponseEntity<User>(HttpStatus.OK);
			}
			else
			{
				throw new RecordAlreadyPresentException("This email is already in use");
			}
		}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<User>(HttpStatus.ALREADY_REPORTED);
		}
	}

	@Override
	public ResponseEntity<User> userLogin(User user) {
		Optional<User> findUser = userRepo.findById(user.getEmail());
		try {
			if(!findUser.isPresent())
			{
				return new ResponseEntity<User>(HttpStatus.OK);
			}
			else
			{
				throw new RecordNotFoundException("Invalid email or password");
			}
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<User> changePassword(User user) {
		Optional<User> findUser = userRepo.findById(user.getEmail());
		try {
			if(findUser.isPresent())
			{
				userRepo.save(user);
				return new ResponseEntity<User>(HttpStatus.OK);
			}
			else
			{
				throw new RecordNotFoundException("Email not found");
			}
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public String forgotPassword(User user) {
		return null;
	}

	@Override
	public String generateOtp() {
		return null;
	}

	@Override
	public String sendOtp() {
		return null;
	}
}
