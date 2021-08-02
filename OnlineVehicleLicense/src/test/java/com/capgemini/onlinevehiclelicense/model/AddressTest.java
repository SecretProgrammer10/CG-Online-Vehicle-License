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
class AddressTest {
	
	static Address address;
	Address addr;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		address = new Address("01","Mannat", "Maharashtra", "Mumbai", "Land's End", 400050, null);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		address = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		addr = new Address();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		addr = null;
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#Address()}.
	 */
	@Test
	void testAddress() {
		assertEquals(new Address(), addr);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#Address(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.capgemini.onlinevehiclelicense.model.Applicant)}.
	 */
	@Test
	void testAddressStringStringStringStringStringIntApplicant() {
		assertEquals(new Address("01","Mannat", "Maharashtra", "Mumbai", "Land's End", 400050, null), address);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getAddrId()}.
	 */
	@Test
	void testGetAddrId() {
		assertEquals("01",address.getAddrId());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getHouse()}.
	 */
	@Test
	void testGetHouse() {
		assertEquals("Mannat",address.getHouse());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setHouse(java.lang.String)}.
	 */
	@Test
	void testSetHouse() {
		addr.setHouse("Mannat");
		assertEquals("Mannat", addr.getHouse());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getState()}.
	 */
	@Test
	void testGetState() {
		assertEquals("Maharashtra",address.getState());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setState(java.lang.String)}.
	 */
	@Test
	void testSetState() {
		addr.setState("Maharashtra");
		assertEquals("Maharashtra",addr.getState());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getCity()}.
	 */
	@Test
	void testGetCity() {
		assertEquals("Mumbai",address.getCity());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setCity(java.lang.String)}.
	 */
	@Test
	void testSetCity() {
		addr.setCity("Mumbai");
		assertEquals("Mumbai", addr.getCity());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getLandmark()}.
	 */
	@Test
	void testGetLandmark() {
		assertEquals("Land's End", address.getLandmark());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setLandmark(java.lang.String)}.
	 */
	@Test
	void testSetLandmark() {
		addr.setLandmark("Land's End");
		assertEquals("Land's End", addr.getLandmark());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getPincode()}.
	 */
	@Test
	void testGetPincode() {
		assertEquals(400050, address.getPincode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setPincode(int)}.
	 */
	@Test
	void testSetPincode() {
		addr.setPincode(400050);
		assertEquals(400050, addr.getPincode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getApplicant()}.
	 */
	@Test
	void testGetApplicant() {
		assertEquals(null,address.getApplicant());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setApplicant(com.capgemini.onlinevehiclelicense.model.Applicant)}.
	 */
/*	@Test
	void testSetApplicant() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals("Address [addrId=01, house=Mannat, state=Maharashtra, city=Mumbai, landmark=Land's End, pincode=400050, applicant=null]", address.toString());
	}

}
