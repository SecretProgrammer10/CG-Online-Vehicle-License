package com.capgemini.onlinevehiclelicense.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsersTest {
	
	static Users users;
	Users u;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//users = new Users("jane.doe@johndoehub.com","Johndoe@1234");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		users = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		u = new Users();
	}

	@AfterEach
	void tearDown() throws Exception {
		u = null;
	}

	@Test
	void testHashCode() {
		//assertEquals(new Users("jane.doe@johndoehub.com","Johndoe@1234").hashCode(),users.hashCode());
	}

	@Test
	void testUsers() {
		assertEquals(new Users(), u);
	}

	@Test
	void testUsersStringString() {
		//assertEquals(new Users("jane.doe@johndoehub.com","Johndoe@1234"),users);
	}

	@Test
	void testGetEmail() {
		assertEquals("jane.doe@johndoehub.com", users.getEmail());
	}

	@Test
	void testSetEmail() {
		u.setEmail("jane.doe@johndoehub.com");
		assertEquals("jane.doe@johndoehub.com", u.getEmail());
	}

	@Test
	void testGetPassword() {
		assertEquals("Johndoe@1234",users.getPassword());
	}

	@Test
	void testSetPassword() {
		u.setPassword("Johndoe@1234");
		assertEquals("Johndoe@1234",u.getPassword());
	}

	@Test
	void testEqualsObject() {
		//assertEquals(new Users("jane.doe@johndoehub.com","Johndoe@1234").equals(users),true);
	}

	@Test
	void testToString() {
		//assertEquals(new Users("jane.doe@johndoehub.com","Johndoe@1234").toString(), users.toString());
	}

}
