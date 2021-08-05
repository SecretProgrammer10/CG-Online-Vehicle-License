/**
 * 
 */
package com.capgemini.onlinevehiclelicense.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
import java.util.TimeZone;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.LicenseType;
import com.capgemini.onlinevehiclelicense.service.LicenseService;
//import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = LicenseController.class)
@ActiveProfiles("test")
class LicenseControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	//@Autowired
	//private ObjectMapper objectMapper;
	
	@MockBean
	private LicenseService licenseService;
	
	private Page<License> licenseList;
	private License license;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		licenseList.and(new License("20214738292", LicenseType.DL, 
				new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"), new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-03")));
	}
	
	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.LicenseController#addLicense(com.capgemini.onlinevehiclelicense.model.License)}.
	 */
	@Test
	void testAddLicense() {
		
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.LicenseController#renewLicense(com.capgemini.onlinevehiclelicense.model.License, java.lang.String)}.
	 */
	@Test
	void testRenewLicense() {
		
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.LicenseController#viewAllLicense()}.
	 * @throws Exception 
	 */
	@Test
	void testViewAllLicense(Pageable pageable) throws Exception {
		given(licenseService.viewAllLicense(pageable)).willReturn(this.licenseList);
		
		this.mockMvc.perform(get("/api/v1/license/view-all-licenses"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(licenseList.getSize())));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.LicenseController#viewLicenseByLicenseNumber(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	void testViewLicenseByLicenseNumber() throws Exception {
		String licenseNumber = "20214738292";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		license = new License(licenseNumber, LicenseType.DL, 
				new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"), new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-03"));
		
		given(licenseService.viewLicenseByNumber("20214738292")).willReturn(license);
		
		this.mockMvc.perform(get("/api/v1/license/view-license/{licenseNumber}", licenseNumber))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.licenseNumber", is(license.getLicenseNumber())))
		.andExpect(jsonPath("$.licenseType", is(license.getLicenseType().toString())))
		.andExpect(jsonPath("$.dateOfIssue", is(sdf.format(license.getDateOfIssue()))))
		.andExpect(jsonPath("$.validTill", is(sdf.format(license.getValidTill()))));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.LicenseController#viewLicenseByType(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	void testViewLicenseByType() throws Exception {
		LicenseType licenseType = LicenseType.DL;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		license = new License("20214738292", licenseType, 
				new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"), new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-03"));
		
		given(licenseService.viewLicenseByType(licenseType.toString())).willReturn(license);
		
		this.mockMvc.perform(get("/api/v1/license/view-license-by-type/{licenseType}", licenseType.toString()))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.licenseNumber", is(license.getLicenseNumber())))
		.andExpect(jsonPath("$.licenseType", is(license.getLicenseType().toString())))
		.andExpect(jsonPath("$.dateOfIssue", is(sdf.format(license.getDateOfIssue()))))
		.andExpect(jsonPath("$.validTill", is(sdf.format(license.getValidTill()))));
	}

}
