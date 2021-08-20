package com.capgemini.onlinevehiclelicense.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.model.Users;
import com.capgemini.onlinevehiclelicense.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4205")
@RestController
@RequestMapping("/user")
@Api(value = "Online Vehicle License")
public class UserController {
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "Register Users")
	@PostMapping("/register-user")
	public ResponseEntity<String> registerUser(@Valid @RequestBody Users user)
	{
		return userService.userRegistration(user);
	}
	
	@ApiOperation(value = "Login Users")
	@PostMapping("/login-user")
	public ResponseEntity<String> loginUser(@Valid @RequestParam String username,@Valid @RequestParam String pass)
	{
		return userService.userLogin(username, pass);
	}
	
	@ApiOperation(value = "Change Password")
	@PutMapping("/change-password")
	public ResponseEntity<String> changePassword(@Valid @RequestParam String email,@Valid @RequestParam String pass,@Valid @RequestParam String newPass)
	{
		return userService.changePassword(email, pass, newPass);
	}
	
	@ApiOperation(value = "Forget Password")
	@PutMapping("/forget-password")
	public ResponseEntity<String> forgetPassword(@Valid @RequestParam String email, @Valid @RequestParam String pass){
		return userService.forgotPassword(email, pass);
	}
	
	@ApiOperation(value = "Get a page of all users")
	@GetMapping("/all-users")
	public Page<Users> getAllUsers(Pageable pageable){
		return this.userService.getAllUsers(pageable);
	}
	
	@ApiOperation(value = "Get user by email")
	@GetMapping("email/{email}")
	public Users getUserByEmail(@PathVariable("email") String email) {
		return this.userService.getUserByEmail(email);
	}
	
	@GetMapping("username/{username}")
	public Users getUserById(@PathVariable("username") String username) {
		return this.userService.getUserById(username);
	}
}
