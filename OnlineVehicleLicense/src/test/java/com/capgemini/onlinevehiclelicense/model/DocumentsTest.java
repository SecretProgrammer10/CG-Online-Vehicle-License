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
class DocumentsTest {
	
	static Documents documents;
	Documents docs;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		documents = new Documents("1", "John_Doe_photo.pdf", "John_Doe_Voter.pdf", "John_Doe_Aadhaar.pdf");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		documents = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		docs = new Documents();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		docs = null;
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(new Documents("1", "John_Doe_photo.pdf", "John_Doe_Voter.pdf", "John_Doe_Aadhaar.pdf").hashCode(),documents.hashCode());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#Documents()}.
	 */
	@Test
	void testDocuments() {
		assertEquals(new Documents(), docs);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#Documents(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testDocumentsStringStringStringString() {
		assertEquals(new Documents("1", "John_Doe_photo.pdf", "John_Doe_Voter.pdf", "John_Doe_Aadhaar.pdf"),documents);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#getId()}.
	 */
	@Test
	void testGetId() {
		assertEquals(documents.getId(),"1");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#setId(java.lang.String)}.
	 */
	@Test
	void testSetId() {
		docs.setId("10");
		assertEquals(docs.getId(),"10");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#getApplication()}.
	 */
	@Test
	void testGetApplication() {
		assertEquals(documents.getApplication(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#setApplication(com.capgemini.onlinevehiclelicense.model.Application)}.
	 */
	@Test
	void testSetApplication() {
		docs.setApplication(null);
		assertEquals(docs.getApplication(),null);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#getPhoto()}.
	 */
	@Test
	void testGetPhoto() {
		assertEquals(documents.getPhoto(),"John_Doe_photo.pdf");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#setPhoto(java.lang.String)}.
	 */
	@Test
	void testSetPhoto() {
		docs.setPhoto("Jane_Doe_photo.pdf");
		assertEquals(docs.getPhoto(),"Jane_Doe_photo.pdf");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#getIdProof()}.
	 */
	@Test
	void testGetIdProof() {
		assertEquals(documents.getIdProof(),"John_Doe_Voter.pdf");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#setIdProof(java.lang.String)}.
	 */
	@Test
	void testSetIdProof() {
		docs.setIdProof("Jane_Doe_Voter.pdf");
		assertEquals(docs.getIdProof(),"Jane_Doe_Voter.pdf");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#getAddressProof()}.
	 */
	@Test
	void testGetAddressProof() {
		assertEquals(documents.getAddressProof(),"John_Doe_Aadhaar.pdf");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#setAddressProof(java.lang.String)}.
	 */
	@Test
	void testSetAddressProof() {
		docs.setAddressProof("Jane_Doe_Aadhaar.pdf");
		assertEquals(docs.getAddressProof(),"Jane_Doe_Aadhaar.pdf");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		assertEquals(new Documents("1", "John_Doe_photo.pdf", "John_Doe_Voter.pdf", "John_Doe_Aadhaar.pdf").equals(documents),true);
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.model.Documents#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(new Documents("1", "John_Doe_photo.pdf", "John_Doe_Voter.pdf", "John_Doe_Aadhaar.pdf").toString(),"Documents [id=1, application=null, photo=John_Doe_photo.pdf, idProof=John_Doe_Voter.pdf, addressProof=John_Doe_Aadhaar.pdf]");
	}

}
