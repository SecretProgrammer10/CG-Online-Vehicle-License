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
 * @author Riddhi Das
 *
 */
class RTOOfficeTest {
	
	static RTOOffice rtooffice;
	RTOOffice rtoOff;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		rtooffice= new RTOOffice(1,"RamaKrishna"); 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		rtooffice=null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		rtoOff= new RTOOffice();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		rtoOff =null;
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#hashCode()}.
	 */
	@Test
	void testHashCode() {
		
		assertEquals(new RTOOffice(1,"RamaKrishna").hashCode(), rtooffice.hashCode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#RTOOffice()}.
	 */
	@Test
	void testRTOOffice() {
		assertEquals(new RTOOffice(),rtoOff);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#RTOOffice(int, java.lang.String)}.
	 */
	@Test
	void testRTOOfficeIntString() {
		assertEquals(new RTOOffice(1,"RamaKrishna"),rtooffice);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#getRtoId()}.
	 */
	@Test
	void testGetRtoId() {
		assertEquals(rtooffice.getRtoId(),1);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#setRtoId(int)}.
	 */
	@Test
	void testSetRtoId() {
		rtoOff.setRtoId(1);
		assertEquals(rtoOff.getRtoId(),1);
		
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#getRtoName()}.
	 */
	@Test
	void testGetRtoName() {
		assertEquals(rtooffice.getRtoName(),"RamaKrishna");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#setRtoName(java.lang.String)}.
	 */
	@Test
	void testSetRtoName() {
		rtoOff.setRtoName("RamaKrishna");
		assertEquals(rtoOff.getRtoName(), "RamaKrishna");
		
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#getRtoOfficer()}.
	 */
	@Test
	void testGetRtoOfficer() {
		assertEquals(rtooffice.getRtoOfficer(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#setRtoOfficer(java.util.Set)}.
	 */
	@Test
	void testSetRtoOfficer() {
		rtoOff.setRtoOfficer(null);
		assertEquals(rtoOff.getRtoOfficer(), null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#getApplication()}.
	 */
	@Test
	void testGetApplication() {
		
		assertEquals(rtooffice.getApplication(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#setApplication(java.util.Set)}.
	 */
	@Test
	void testSetApplication() {
		rtoOff.setApplication(null);
		assertEquals(rtoOff.getApplication(), null);
	
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#getLicense()}.
	 */
	@Test
	void testGetLicense() {
		assertEquals(rtooffice.getLicense(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#setLicense(java.util.Set)}.
	 */
	@Test
	void testSetLicense() {
		rtoOff.setLicense(null);
		assertEquals(rtoOff.getLicense(), null);
	
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		
		assertEquals(new RTOOffice(1, "RamaKrishna").equals(rtooffice),true);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.RTOOffice#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals((new RTOOffice(1, "RamaKrishna")).toString(),"RTOOffice [rtoId=1, rtoName=RamaKrishna, rtoOfficer=null, application=null, appointment=null, license=null]");
	}

}
