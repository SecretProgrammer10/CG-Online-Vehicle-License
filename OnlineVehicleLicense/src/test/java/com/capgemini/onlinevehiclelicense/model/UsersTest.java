/**
 * 
 */
package com.capgemini.onlinevehiclelicense.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author DIBYENDU
 *
 */
class UsersTest {
	
	static Users users;
	Users user;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		users = new Users("johndoe@gmail.com", "John@12", "JohnDoe@1234");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		users = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		user = new Users();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		user = null;
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(new Users("johndoe@gmail.com", "John@12", "JohnDoe@1234").hashCode(),users.hashCode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#Users()}.
	 */
	@Test
	void testUsers() {
		assertEquals(new Users(), user);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#Users(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testUsersStringStringString() {
		assertEquals(new Users("johndoe@gmail.com", "John@12", "JohnDoe@1234"), users);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#getEmail()}.
	 */
	@Test
	void testGetEmail() {
		assertEquals(users.getEmail(),"johndoe@gmail.com");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#setEmail(java.lang.String)}.
	 */
	@Test
	void testSetEmail() {
		user.setEmail("janedoe@gmail.com");
		assertEquals(user.getEmail(),"janedoe@gmail.com");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#getUsername()}.
	 */
	@Test
	void testGetUsername() {
		assertEquals(users.getUsername(),"John@12");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#setUsername(java.lang.String)}.
	 */
	@Test
	void testSetUsername() {
		user.setUsername("Jane@34");
		assertEquals(user.getUsername(),"Jane@34");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#getPassword()}.
	 */
	@Test
	void testGetPassword() {
		assertEquals(users.getPassword(),"JohnDoe@1234");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#setPassword(java.lang.String)}.
	 */
	@Test
	void testSetPassword() {
		user.setPassword("JaneDoe@1234");
		assertEquals(user.getPassword(),"JaneDoe@1234");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#getApplicant()}.
	 */
	@Test
	void testGetApplicant() {
		assertEquals(users.getApplicant(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#setApplicant(com.capgemini.onlinevehiclelicense.model.Applicant)}.
	 */
	@Test
	void testSetApplicant() {
		user.setApplicant(null);
		assertEquals(user.getApplicant(), null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		assertEquals(new Users("johndoe@gmail.com", "John@12", "JohnDoe@1234").equals(users),true);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Users#toString()}.
	 */
	@Test
	void testToString() {
		
	}

}
