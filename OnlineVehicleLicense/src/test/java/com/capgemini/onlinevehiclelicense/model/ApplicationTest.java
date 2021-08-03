package com.capgemini.onlinevehiclelicense.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author SHRUTI
 *
 */

class ApplicationTest {
	static Application application;
	Application app;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		application = new Application("101", LocalDate.parse("13-08-2021"), "COD", 2040.00, "Paid", null, ApplicationStatus.APPROVED, LicenseType.DL);
	}
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		application = null;
	}
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		app = new Application();
	}
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		app = null;
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(new Application("101", LocalDate.parse("13-08-2021"), "COD", 2040.00, "Paid", null, ApplicationStatus.APPROVED,LicenseType.DL).hashCode(), application.hashCode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#ApplicationS()}.
	 */
	@Test
	void testApplication() {
		assertEquals(new Application(), app);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#Application(java.lang.String, java.util.LocalDate, int, java.lang.String, java.lang.String, java.lang.String, int, com.capgemini.onlinevehiclelicense.model.ApplicationStatus, com.capgemini.onlinevehiclelicense.model.LicenseType)}.
	 */
	@Test
	void testAddressStringLocalDateIntStringStringStringIntApplicationStatusLicenseType() {
		assertEquals(new Application("101", LocalDate.parse("13-08-2021"), "COD", 2040.00, "Paid", null, ApplicationStatus.APPROVED,LicenseType.DL), application);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#getApplicationNumber()}.
	 */
	@Test
	void testGetAddrId() {
		assertEquals(application.getApplicationNumber(),"101");
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#setApplicationNumber(java.lang.String)}.
	 */
	@Test
	void testSetApplicationNumber() {
		app.setApplicationNumber("101");
		assertEquals(app.getApplicationNumber(),"101");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#getApplicationDate(java.time.LocalDate)}.
	 */
	@Test
	void testGetApplicationDate() {
		assertEquals(application.getApplicationDate(), LocalDate.parse("13-08-2021") );
	}
	
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#setApplicationNumber(java.time.LocalDate)}.
	 */
	@Test
	void testSetApplicationDate() {
		app.setApplicationDate(LocalDate.parse("13-08-2021"));
		assertEquals(app.getApplicationNumber(), LocalDate.parse("13-08-2021"));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#getModeOfPayment()}.
	 */
	@Test
	void testGetModeOfPayment() {
		assertEquals(application.getModeOfPayment(),"COD");
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#setModeOfPayment(java.lang.String)}.
	 */
	@Test
	void testSetModeOfPayment() {
		app.setModeOfPayment("COD");
		assertEquals(app.getModeOfPayment(), "COD");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#getAmountPaid(double)}.
	 */
	@Test
	void testGetAmountPaid() {
		assertEquals(application.getAmountPaid(),2040.00);
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#setAmountPaid}.
	 */
	@Test
	void testSetAmountPaid() {
		app.setAmountPaid(2040.00);
		assertEquals(app.getAmountPaid(),2040.00);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#getPaymentStatus()}.
	 */
	@Test
	void testGetPaymentStatus() {
		assertEquals(application.getPaymentStatus(),"Paid");
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#setPaymentStatus(java.lang.String)}.
	 */
	@Test
	void testSetPaymentStatus() {
		app.setPaymentStatus("Paid");
		assertEquals(app.getPaymentStatus(),"Paid");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#getRemarks()}.
	 */
	@Test
	void testGetRemarks() {
		assertEquals(application.getRemarks(),null);
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#setRemarks(java.lang.String)}.
	 */
	@Test
	void testSetRemarks() {
		app.setRemarks(null);
		assertEquals(app.getRemarks(), null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#getApplicationStatus()}.
	 */
	@Test
	void testGetApplicant() {
		assertEquals(application.getApplicationStatus(), ApplicationStatus.APPROVED);
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#setApplicationStatus(com.capgemini.onlinevehiclelicense.model.ApplicationStatus)}.
	 */
	@Test
	void testSetApplicationStatus() {
		app.setApplicationStatus(ApplicationStatus.APPROVED);
		assertEquals(app.getApplicationStatus(), ApplicationStatus.APPROVED);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#getApplicationType()}.
	 */
	@Test
	void testGetApplicationType() {
		assertEquals(application.getApplicationType(), LicenseType.DL);
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#setApplicationType(com.capgemini.onlinevehiclelicense.model.LicenseType)}.
	 */
	@Test
	void testSetApplicationType() {
		app.setApplicationType(LicenseType.DL);
		assertEquals(app.getApplicationType(), LicenseType.DL);
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#getDocuments()}.
	 */
	@Test
	void testGetDocuments() {
		assertEquals(application.getDocs(),null);
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#setDocuments(java.lang.String)}.
	 */
	@Test
	void testSetDocuments() {
		app.setDocs(null);
		assertEquals(app.getDocs(), null);
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#getLicense()}.
	 */
	@Test
	void testGetLicense() {
		assertEquals(application.getLicense(),null);
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#setLicense(java.lang.String)}.
	 */
	@Test
	void testSetLicense() {
		app.setLicense(null);
		assertEquals(app.getLicense(), null);
	}
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		assertEquals(new Application("101", LocalDate.parse("13-08-2021"), "COD", 2040.00, "Paid", null, ApplicationStatus.APPROVED,LicenseType.DL).equals(application),true);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Application#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(new Application("101", LocalDate.parse("13-08-2021"), "COD", 2040.00, "Paid", null, ApplicationStatus.APPROVED,LicenseType.DL).toString(),"Address [applicationNumber=101, applicationDate=Fri Aug 13, modeOfPayment=COD, amountPaid=2040.00, paymentStatus=Paid, remarks=null, applicationStatus=APPROVED, applicationType=DL, docs=null, license=null]");
	}



}
	