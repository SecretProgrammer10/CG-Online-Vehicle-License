package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.User;
import com.capgemini.onlinevehiclelicense.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/registerUser")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void registerUser(@RequestBody User user)
	{
		userService.userRegistration(user);
	}
	@GetMapping("/loginUser")
	@ExceptionHandler(RecordNotFoundException.class)
	public void loginUser(@RequestBody User user)
	{
		userService.userLogin(user);
	}
	@PutMapping("/changePassword")
	@ExceptionHandler(RecordNotFoundException.class)
	public void changePassword(@RequestBody User user)
	{
		userService.changePassword(user);
	}
}
