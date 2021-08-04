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

class ChallanTest {
	
	static Challan challan;
	Challan ch;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		challan = new Challan("21-09876", "MH0985L56", 500.00, "PAID");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		challan = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ch = new Challan();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		ch = null;
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Challan#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(new Challan("21-09876", "MH0985L56", 500.00, "PAID").hashCode(), challan.hashCode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Challan#Challan()}.
	 */
	@Test
	void testChallan() {
		assertEquals(new Challan(), ch);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Challan#Challan(java.lang.String, java.lang.String, java.lang.Double, java.lang.String)}.
	 */
	@Test
	void testChallanStringStringDoubleString() {
		assertEquals(new Challan("21-09876", "MH0985L56", 500.00, "PAID"), challan);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Challan#getChallanNumber()}.
	 */
	@Test
	void testGetChallanNumber() {
		assertEquals(challan.getChallanNumber(), "21-09876");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Challan#setChallanNumber(java.lang.String)}.
	 */
	@Test
	void testSetChallanNumber() {
		ch.setChallanNumber("21-09899");
		assertEquals(ch.getChallanNumber(), "21-09899");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Challan#getAmount()}.
	 */
	@Test
	void testGetAmount() {
		assertEquals(challan.getAmount(), 500.00);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Challan#setAmount(java.lang.Double)}.
	 */
	@Test
	void testSetAmount() {
		ch.setAmount(1000.00);
		assertEquals(ch.getAmount(), 1000.00);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Challan#getStatus()}.
	 */
	@Test
	void testGetStatus() {
		assertEquals(challan.getStatus(), "PAID");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Challan#setStatus(java.lang.String)}.
	 */
	@Test
	void testSetStatus() {
		ch.setStatus("NOT PAID");
		assertEquals(ch.getStatus(), "NOT PAID");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Challan#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(new Challan("21-09876", "MH0985L56", 500.00, "PAID").toString(),
				"Challan [challanNumber=21-09876, vehicleNumber=MH0985L56, amount=500.0, status=PAID]");
	}

}
