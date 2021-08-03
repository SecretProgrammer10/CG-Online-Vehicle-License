/**
 * 
 */
package com.capgemini.onlinevehiclelicense.model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Shubham
 *
 */
class ApplicantTest {
	static Applicant applicant;
	Applicant obj;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		applicant = new Applicant("123","Neil","Nitin","Mukesh",new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"),"Mumbai",Gender.MALE,"Bachelor's in Commerce","9876543210","Indian","Car","2277");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		applicant = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		obj = new Applicant();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		obj = null;
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#hashCode()}.
	 * @throws ParseException 
	 */
	@Test
	void testHashCode() throws ParseException {
		assertEquals(new Applicant("123","Neil","Nitin","Mukesh",new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"),"Mumbai",Gender.MALE,"Bachelor's in Commerce","9876543210","Indian","Car","2277").hashCode(),applicant.hashCode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#Applicant()}.
	 */
	@Test
	void testApplicant() {
		assertEquals(new Applicant(),obj);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#Applicant(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.lang.String, com.capgemini.onlinevehiclelicense.model.Gender, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws ParseException 
	 */
	@Test
	void testApplicantStringStringStringStringDateStringGenderStringStringStringStringString() throws ParseException {
		assertEquals(new Applicant("123","Neil","Nitin","Mukesh",new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"),"Mumbai",Gender.MALE,"Bachelor's in Commerce","9876543210","Indian","Car","2277"),applicant);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getApplicantId()}.
	 */
	@Test
	void testGetApplicantId() {
		assertEquals(applicant.getApplicantId(),"123");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setApplicantId(java.lang.String)}.
	 */
	@Test
	void testSetApplicantId() {
		obj.setApplicantId("123");
		assertEquals(obj.getApplicantId(),"123");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getFirstName()}.
	 */
	@Test
	void testGetFirstName() {
		assertEquals(applicant.getFirstName(),"Neil");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setFirstName(java.lang.String)}.
	 */
	@Test
	void testSetFirstName() {
		obj.setFirstName("Neil");
		assertEquals(obj.getFirstName(),"Neil");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getMiddleName()}.
	 */
	@Test
	void testGetMiddleName() {
		assertEquals(applicant.getMiddleName(),"Nitin");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setMiddleName(java.lang.String)}.
	 */
	@Test
	void testSetMiddleName() {
		obj.setMiddleName("Nitin");
		assertEquals(obj.getMiddleName(),"Nitin");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getLastName()}.
	 */
	@Test
	void testGetLastName() {
		assertEquals(applicant.getLastName(),"Mukesh");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setLastName(java.lang.String)}.
	 */
	@Test
	void testSetLastName() {
		obj.setLastName("Mukesh");
		assertEquals(obj.getLastName(),"Mukesh");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getDateOfBirth()}.
	 * @throws ParseException 
	 */
	@Test
	void testGetDateOfBirth() throws ParseException {
		assertEquals(applicant.getDateOfBirth(),new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setDateOfBirth(java.util.Date)}.
	 * @throws ParseException 
	 */
	@Test
	void testSetDateOfBirth() throws ParseException {
		obj.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"));
		assertEquals(obj.getDateOfBirth(),new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getPlaceOfBirth()}.
	 */
	@Test
	void testGetPlaceOfBirth() {
		assertEquals(applicant.getPlaceOfBirth(),"Mumbai");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setPlaceOfBirth(java.lang.String)}.
	 */
	@Test
	void testSetPlaceOfBirth() {
		obj.setPlaceOfBirth("Mumbai");
		assertEquals(obj.getPlaceOfBirth(),"Mumbai");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getGender()}.
	 */
	@Test
	void testGetGender() {
		assertEquals(applicant.getGender(),Gender.MALE);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setGender(com.capgemini.onlinevehiclelicense.model.Gender)}.
	 */
	@Test
	void testSetGender() {
		obj.setGender(Gender.MALE);
		assertEquals(obj.getGender(),Gender.MALE);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getQualification()}.
	 */
	@Test
	void testGetQualification() {
		assertEquals(applicant.getQualification(),"Bachelor's in Commerce");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setQualification(java.lang.String)}.
	 */
	@Test
	void testSetQualification() {
		obj.setQualification("Bachelor's in Commerce");
		assertEquals(obj.getQualification(),"Bachelor's in Commerce");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getMobile()}.
	 */
	@Test
	void testGetMobile() {
		assertEquals(applicant.getMobile(),"9876543210");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setMobile(java.lang.String)}.
	 */
	@Test
	void testSetMobile() {
		obj.setMobile("9876543210");
		assertEquals(obj.getMobile(),"9876543210");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getNationality()}.
	 */
	@Test
	void testGetNationality() {
		assertEquals(applicant.getNationality(),"Indian");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setNationality(java.lang.String)}.
	 */
	@Test
	void testSetNationality() {
		obj.setNationality("Indian");
		assertEquals(obj.getNationality(),"Indian");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getVehicleType()}.
	 */
	@Test
	void testGetVehicleType() {
		assertEquals(applicant.getVehicleType(),"Car");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setVehicleType(java.lang.String)}.
	 */
	@Test
	void testSetVehicleType() {
		obj.setVehicleType("Car");
		assertEquals(obj.getVehicleType(),"Car");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getVehicleNumber()}.
	 */
	@Test
	void testGetVehicleNumber() {
		assertEquals(applicant.getVehicleNumber(),"2277");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setVehicleNumber(java.lang.String)}.
	 */
	@Test
	void testSetVehicleNumber() {
		obj.setVehicleNumber("2277");
		assertEquals(obj.getVehicleNumber(),"2277");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getAddress()}.
	 */
	@Test
	void testGetAddress() {
		assertEquals(applicant.getAddress(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setAddress(java.util.Set)}.
	 */
	@Test
	void testSetAddress() {
		obj.setAddress(null);
		assertEquals(obj.getAddress(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getApplication()}.
	 */
	@Test
	void testGetApplication() {
		assertEquals(applicant.getApplication(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setApplication(java.util.Set)}.
	 */
	@Test
	void testSetApplication() {
		obj.setApplication(null);
		assertEquals(obj.getApplication(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getUsers()}.
	 */
	@Test
	void testGetUsers() {
		assertEquals(applicant.getUsers(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setUsers(com.capgemini.onlinevehiclelicense.model.Users)}.
	 */
	@Test
	void testSetUsers() {
		obj.setUsers(null);
		assertEquals(obj.getUsers(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#getChallan()}.
	 */
	@Test
	void testGetChallan() {
		assertEquals(applicant.getChallan(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#setChallan(java.util.Set)}.
	 */
	@Test
	void testSetChallan() {
		obj.setChallan(null);
		assertEquals(obj.getChallan(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#equals(java.lang.Object)}.
	 * @throws ParseException 
	 */
	@Test
	void testEqualsObject() throws ParseException {
		assertEquals(new Applicant("123","Neil","Nitin","Mukesh",new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"),"Mumbai",Gender.MALE,"Bachelor's in Commerce","9876543210","Indian","Car","2277").equals(applicant),true);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Applicant#toString()}.
	 * @throws ParseException 
	 */
	@Test
	void testToString() throws ParseException {
		assertEquals(new Applicant("123","Neil","Nitin","Mukesh",new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"),"Mumbai",Gender.MALE,"Bachelor's in Commerce","9876543210","Indian","Car","2277").toString(),"Applicant [getApplicantId()=123, getFirstName()=Neil, getMiddleName()=Nitin, getLastName()=Mukesh, getDateOfBirth()=Fri Jan 15 00:00:00 IST 1982, getPlaceOfBirth()=Mumbai, getGender()=MALE, getQualification()=Bachelor's in Commerce, getMobile()=9876543210, getNationality()=Indian, getVehicleType()=Car, getVehicleNumber()=2277, getAddress()=null]");
	}

}
