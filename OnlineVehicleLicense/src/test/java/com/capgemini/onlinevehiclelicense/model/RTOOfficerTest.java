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
class RTOOfficerTest {
	
	static RTOOfficer rtoOfficer;
	RTOOfficer rtoOfcr;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		rtoOfficer = new RTOOfficer("John@12", "JohnDoe@1234","johndoe@gmail.com");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		rtoOfficer = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		rtoOfcr = new RTOOfficer();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		rtoOfcr = null;
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(new RTOOfficer("John@12", "JohnDoe@1234","johndoe@gmail.com").hashCode(),rtoOfficer.hashCode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#RTOOfficer()}.
	 */
	@Test
	void testRTOOfficer() {
		assertEquals(new RTOOfficer(), rtoOfcr);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#RTOOfficer(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testRTOOfficerStringStringString() {
		assertEquals(new RTOOfficer("John@12", "JohnDoe@1234","johndoe@gmail.com"), rtoOfficer);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#getUsername()}.
	 */
	@Test
	void testGetUsername() {
		assertEquals(rtoOfficer.getUsername(),"John@12");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#setUsername(java.lang.String)}.
	 */
	@Test
	void testSetUsername() {
		rtoOfcr.setUsername("Jane@12");
		assertEquals(rtoOfcr.getUsername(),"Jane@12");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#getPassword()}.
	 */
	@Test
	void testGetPassword() {
		assertEquals(rtoOfficer.getPassword(),"JohnDoe@1234");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#setPassword(java.lang.String)}.
	 */
	@Test
	void testSetPassword() {
		rtoOfcr.setPassword("JaneDoe@1234");
		assertEquals(rtoOfcr.getPassword(),"JaneDoe@1234");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#getEmail()}.
	 */
	@Test
	void testGetEmail() {
		assertEquals(rtoOfficer.getEmail(), "johndoe@gmail.com");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#setEmail(java.lang.String)}.
	 */
	@Test
	void testSetEmail() {
		rtoOfcr.setEmail("janedoe@gmail.com");
		assertEquals(rtoOfcr.getEmail(),"janedoe@gmail.com");
	}


	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#getRtoOffice()}.
	 */
	@Test
	void testGetRtoOffice() {
		assertEquals(rtoOfficer.getRtoOffice(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#setRtoOffice(com.capgemini.onlinevehiclelicense.model.RTOOffice)}.
	 */
	@Test
	void testSetRtoOffice() {
		rtoOfcr.setRtoOffice(null);
		assertEquals(rtoOfcr.getRtoOffice(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		assertEquals(new RTOOfficer("John@12", "JohnDoe@1234","johndoe@gmail.com").equals(rtoOfficer),true);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOfficer#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals((new RTOOfficer("John@12", "JohnDoe@1234","johndoe@gmail.com")).toString(), "RTOOfficer [username=John@12, password=JohnDoe@1234, email=johndoe@gmail.com, rtoOffice=null]");
	}

}
