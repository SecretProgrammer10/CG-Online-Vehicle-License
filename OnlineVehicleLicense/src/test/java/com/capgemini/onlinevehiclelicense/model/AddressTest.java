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
		address = new Address("1", "Mannat, Land's End, Bandstand, Bandra (West)", "Maharashtra", "Mumbai", null, 400050);
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
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(new Address("1", "Mannat, Land's End, Bandstand, Bandra (West)", "Maharashtra", "Mumbai", null, 400050).hashCode(), address.hashCode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#Address()}.
	 */
	@Test
	void testAddress() {
		assertEquals(new Address(), addr);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#Address(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.capgemini.onlinevehiclelicense.model.AddressType)}.
	 */
	@Test
	void testAddressStringStringStringStringStringIntAddressType() {
		assertEquals(new Address("1", "Mannat, Land's End, Bandstand, Bandra (West)", "Maharashtra", "Mumbai", null, 400050), address);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getAddrId()}.
	 */
	@Test
	void testGetAddrId() {
		assertEquals(address.getAddrId(),"1");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setAddrId(java.lang.String)}.
	 */
	@Test
	void testSetAddrId() {
		addr.setAddrId("1");
		assertEquals(addr.getAddrId(),"1");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getHouse()}.
	 */
	@Test
	void testGetHouse() {
		assertEquals(address.getHouse(), "Mannat, Land's End, Bandstand, Bandra (West)");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setHouse(java.lang.String)}.
	 */
	@Test
	void testSetHouse() {
		addr.setHouse("Mannat, Land's End, Bandstand, Bandra (West)");
		assertEquals(addr.getHouse(), "Mannat, Land's End, Bandstand, Bandra (West)");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getState()}.
	 */
	@Test
	void testGetState() {
		assertEquals(address.getState(),"Maharashtra");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setState(java.lang.String)}.
	 */
	@Test
	void testSetState() {
		addr.setState("Maharashtra");
		assertEquals(addr.getState(), "Maharashtra");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getCity()}.
	 */
	@Test
	void testGetCity() {
		assertEquals(address.getCity(),"Mumbai");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setCity(java.lang.String)}.
	 */
	@Test
	void testSetCity() {
		addr.setCity("Mumbai");
		assertEquals(addr.getCity(),"Mumbai");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getLandmark()}.
	 */
	@Test
	void testGetLandmark() {
		assertEquals(address.getLandmark(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setLandmark(java.lang.String)}.
	 */
	@Test
	void testSetLandmark() {
		addr.setLandmark(null);
		assertEquals(addr.getLandmark(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getPincode()}.
	 */
	@Test
	void testGetPincode() {
		assertEquals(address.getPincode(),400050);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setPincode(int)}.
	 */
	@Test
	void testSetPincode() {
		addr.setPincode(400050);
		assertEquals(addr.getPincode(), 400050);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#getApplicant()}.
	 */
	@Test
	void testGetApplicant() {
		assertEquals(address.getApplicant(), null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#setApplicant(com.capgemini.onlinevehiclelicense.model.Applicant)}.
	 */
	@Test
	void testSetApplicant() {
		addr.setApplicant(null);
		assertEquals(addr.getApplicant(), null);
	}


	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		assertEquals(new Address("1", "Mannat, Land's End, Bandstand, Bandra (West)", "Maharashtra", "Mumbai", null, 400050).equals(address),true);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Address#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(new Address("1", " Mannat, Land's End, Bandstand, Bandra (West)", "Maharashtra", "Mumbai", null, 400050).toString(),"Address [addrId=1, house= Mannat, Land's End, Bandstand, Bandra (West), state=Maharashtra, city=Mumbai, landmark=null, pincode=400050, applicant=null]");
	}

}
