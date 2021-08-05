/**
 * 
 */
package com.capgemini.onlinevehiclelicense.model;

import static org.junit.jupiter.api.Assertions.*;


import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Riddhi Das
 *
 */
class AppointmentTest {
	
	static Appointment appointment;
	Appointment appointment1;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		appointment=new Appointment("123",new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-09"),new SimpleDateFormat(
	            "HH:mm:ss").parse("10:00:00"),TestResult.PASS);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		appointment=null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		appointment1= new Appointment();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		appointment1=null;
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#hashCode()}.
	 * @throws Exception 
	 */
	@Test
	void testHashCode() throws Exception {
		
		assertEquals(new Appointment("123",new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-09"),new SimpleDateFormat("HH:mm:ss").parse("10:00:00"),TestResult.PASS).hashCode(), appointment.hashCode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#Appointment()}.
	 */
	@Test
	void testAppointment() {
		assertEquals(new Appointment(), appointment1);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#Appointment(java.lang.String, java.time.LocalDate, java.time.LocalTime, com.capgemini.onlinevehiclelicense.model.TestResult)}.
	 * @throws Exception 
	 */
	@Test
	void testAppointmentStringLocalDateLocalTimeTestResult() throws Exception {
		assertEquals(new Appointment("123",new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-09"),new SimpleDateFormat("HH:mm:ss").parse("10:00:00"),TestResult.PASS), appointment);
		
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#getAppointmentNumber()}.
	 */
	@Test
	void testGetAppointmentNumber() {
		
		assertEquals(appointment.getAppointmentNumber(),"123");
		
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#setAppointmentNumber(java.lang.String)}.
	 */
	@Test
	void testSetAppointmentNumber() {
		appointment1.setAppointmentNumber("123");
		assertEquals(appointment.getAppointmentNumber(),"123");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#getTestDate()}.
	 * @throws Exception 
	 */
	@Test
	void testGetTestDate() throws Exception {
		
		assertEquals(appointment.getTestDate(), new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-09") );

	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#setTestDate(java.time.LocalDate)}.
	 * @throws Exception 
	 */
	@Test
	void testSetTestDate() throws Exception {
		appointment1.setTestDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-09"));
		assertEquals(appointment.getAppointmentNumber(),"123");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#getTimeSlot()}.
	 * @throws Exception 
	 */
	@Test
	void testGetTimeSlot() throws Exception {
		assertEquals(appointment.getTimeSlot(), new SimpleDateFormat("HH:mm:ss").parse("10:00:00") );

	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#setTimeSlot(java.time.LocalTime)}.
	 * @throws Exception 
	 */
	@Test
	void testSetTimeSlot() throws Exception {
		appointment1.setTestDate(new SimpleDateFormat("HH:mm:ss").parse("10:00:00"));
		assertEquals(appointment.getAppointmentNumber(),"123");
		}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#getTestResult()}.
	 */
	@Test
	void testGetTestResult() {
		assertEquals(appointment.getTestResult(), TestResult.PASS);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#setTestResult(com.capgemini.onlinevehiclelicense.model.TestResult)}.
	 */
	@Test
	void testSetTestResult() {
		appointment1.setTestResult(TestResult.PASS);
		assertEquals(appointment1.getTestResult(), TestResult.PASS);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#getApplication()}.
	 */
	@Test
	void testGetApplication() {
		assertEquals(appointment.getApplication(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#setApplication(com.capgemini.onlinevehiclelicense.model.Application)}.
	 */
	@Test
	void testSetApplication() {
		appointment1.setApplication(null);
		assertEquals(appointment1.getApplication(), null);
	}


	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#equals(java.lang.Object)}.
	 * @throws Exception 
	 */
	@Test
	void testEqualsObject() throws Exception {
		assertEquals(new Appointment("123",new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-09"),new SimpleDateFormat("HH:mm:ss").parse("10:00:00"),TestResult.PASS).equals(appointment),true);
		
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Appointment#toString()}.
	 * @throws Exception 
	 */
	@Test
	void testToString() throws Exception {
		assertEquals(new Appointment("123",new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-09"),new SimpleDateFormat("HH:mm:ss").parse("10:00:00"),TestResult.PASS).toString(),"Appointment [appointmentNumber=123, testDate=2021-08-09, timeSlot=10:00:00, testResult=PASS, application=null, rtoOfficer=null]");
	}

}
