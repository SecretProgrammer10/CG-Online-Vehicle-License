package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Users;
import com.capgemini.onlinevehiclelicense.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value = "Online Vehicle License")
@Validated
public class UserController {
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "Register Users")
	@PostMapping("/registerUser")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Users> registerUser(@RequestBody Users user)
	{
		return userService.userRegistration(user);
	}
	
	@ApiOperation(value = "Login Users")
	@GetMapping("/loginUser")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Users> loginUser(@RequestParam String email, @RequestParam String pass)
	{
		return userService.userLogin(email, pass);
	}
	
	@ApiOperation(value = "Change Password")
	@PutMapping("/changePassword")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Users> changePassword(@RequestBody Users user)
	{
		return userService.changePassword(user);
	}
	
	@ApiOperation(value = "Forget Password")
	@PutMapping("/forgetPassword")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Users> forgetPassword(@RequestBody Users user, @RequestParam String pass){
		return userService.forgotPassword(user, pass);
	}
}
