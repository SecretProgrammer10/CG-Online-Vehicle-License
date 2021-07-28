package com.capgemini.onlinevehiclelicense.repository;

import com.capgemini.onlinevehiclelicense.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUserRepository extends JpaRepository<User, String>{
	public String createUser(User user);
	public String validateLogin(User user);
	public String updateUser(User oldUser, User newUser);
}
