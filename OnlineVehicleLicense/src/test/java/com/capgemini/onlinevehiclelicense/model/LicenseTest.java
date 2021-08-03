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

class LicenseTest {

	static License license;
	License lic;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		license = new License("MH108284622021", LicenseType.DL, 
				new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-02"), new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-02"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		license = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		lic = new License();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		lic = null;
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#hashCode()}.
	 * @throws ParseException 
	 */
	@Test
	void testHashCode() throws ParseException {
		assertEquals(new License("MH108284622021", LicenseType.DL, 
				new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-02"), new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-02")).hashCode(), 
				license.hashCode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#License()}.
	 */
	@Test
	void testLicense() {
		assertEquals(new License(), lic);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#License(java.lang.String, com.capgemini.onlinevehiclelicense.model.LicenseType, java.util.Date, java.util.Date)}.
	 * @throws ParseException 
	 */
	@Test
	void testLicenseStringLicenseTypeDateDate() throws ParseException {
		assertEquals(new License("MH108284622021", LicenseType.DL, 
				new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-02"), new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-02")), license);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#getLicenseNumber()}.
	 */
	@Test
	void testGetLicenseNumber() {
		assertEquals(license.getLicenseNumber(), "MH108284622021");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#setLicenseNumber(java.lang.String)}.
	 */
	@Test
	void testSetLicenseNumber() {
		lic.setLicenseNumber("MH108285522021");
		assertEquals(lic.getLicenseNumber(), "MH108285522021");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#getLicenseType()}.
	 */
	@Test
	void testGetLicenseType() {
		assertEquals(license.getLicenseType(), LicenseType.DL);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#setLicenseType(com.capgemini.onlinevehiclelicense.model.LicenseType)}.
	 */
	@Test
	void testSetLicenseType() {
		lic.setLicenseType(LicenseType.LL);
		assertEquals(lic.getLicenseType(), LicenseType.LL);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#getDateOfIssue()}.
	 * @throws ParseException 
	 */
	@Test
	void testGetDateOfIssue() throws ParseException {
		assertEquals(license.getDateOfIssue(), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-02"));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#setDateOfIssue(java.util.Date)}.
	 * @throws ParseException 
	 */
	@Test
	void testSetDateOfIssue() throws ParseException {
		lic.setDateOfIssue(new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-02"));
		assertEquals(lic.getDateOfIssue(), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-02"));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#getValidTill()}.
	 * @throws ParseException 
	 */
	@Test
	void testGetValidTill() throws ParseException {
		assertEquals(license.getValidTill(), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-02"));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#setValidTill(java.util.Date)}.
	 * @throws ParseException 
	 */
	@Test
	void testSetValidTill() throws ParseException {
		lic.setValidTill(new SimpleDateFormat("yyyy-MM-dd").parse("2022-08-02"));
		assertEquals(lic.getValidTill(), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-08-02"));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.License#toString()}.
	 * @throws ParseException 
	 */
	@Test
	void testToString() throws ParseException {
		assertEquals(new License("MH108284622021", LicenseType.DL, 
				new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-02"), new SimpleDateFormat("yyyy-MM-dd").parse("2022-08-02")).toString(), 
				"License [licenseNumber=MH108284622021, licenseType=DL, dateOfIssue=Fri Jul 02 00:00:00 IST 2021, validTill=Tue Aug 02 00:00:00 IST 2022, application=null, rtoOffice=null]");
	}

}
