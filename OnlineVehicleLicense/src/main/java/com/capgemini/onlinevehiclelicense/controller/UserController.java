package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.capgemini.onlinevehiclelicense.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@ApiOperation(value = "Register User")
	@PostMapping("/registerUser")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<User> registerUser(@RequestBody User user)
	{
		return userService.userRegistration(user);
	}
	@ApiOperation(value = "Login User")
	@GetMapping("/loginUser")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<User> loginUser(@RequestBody User user)
	{
		return userService.userLogin(user);
	}
	@ApiOperation(value = "Change Password")
	@PutMapping("/changePassword")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<User> changePassword(@RequestBody User user)
	{
		return userService.changePassword(user);
	}
}
