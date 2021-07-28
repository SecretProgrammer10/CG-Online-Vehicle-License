package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String userRegistration(User user)
	{
		Optional<User> findUser = userRepo.findById(user.getEmail());
		try {
			if(!findUser.isPresent())
			{
				userRepo.save(user);
				return "user registered";
			}
			else
			{
				throw new RecordAlreadyPresentException("This email is already in use");
			}
		}
		catch(RecordAlreadyPresentException e)
		{
			return e.getMessage();
		}
	}

	@Override
	public String userLogin(User user) {
		Optional<User> findUser = userRepo.findById(user.getEmail());
		try {
			if(!findUser.isPresent())
			{
				return "logged in";
			}
			else
			{
				throw new RecordNotFoundException("Invalid email or password");
			}
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}

	@Override
	public String changePassword(User user) {
		Optional<User> findUser = userRepo.findById(user.getEmail());
		try {
			if(findUser.isPresent())
			{
				userRepo.save(user);
				return "password changed";
			}
			else
			{
				throw new RecordNotFoundException("Email not found");
			}
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
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
