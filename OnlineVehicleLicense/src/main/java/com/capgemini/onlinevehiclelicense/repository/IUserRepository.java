package com.capgemini.onlinevehiclelicense.repository;

import com.capgemini.onlinevehiclelicense.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUserRepository extends JpaRepository<Users, String>{
	/*public String createUser(Users user);
	public String validateLogin(Users user);
	public String updateUser(Users oldUser, Users newUser);
	*/
}
