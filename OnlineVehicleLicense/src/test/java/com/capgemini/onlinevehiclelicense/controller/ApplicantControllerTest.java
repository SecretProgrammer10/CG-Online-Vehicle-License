/**
 * 
 */
package com.capgemini.onlinevehiclelicense.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.model.Gender;
import com.capgemini.onlinevehiclelicense.service.ApplicantService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Shubham
 *
 */
@WebMvcTest(controllers = ApplicantController.class)
@ActiveProfiles("test")
class ApplicantControllerTest {

	 private static final int ResponseEntity = 0;

		@Autowired
		    private MockMvc mockMvc;

		    @MockBean
		    private ApplicantService applicantService;

		    @Autowired
		    private ObjectMapper objectMapper;

		    private List<Applicant> applicantList;

		/**
		 * @throws java.lang.Exception
		 */
		@BeforeEach
		void setUp() throws Exception {
			this.applicantList = new ArrayList<>();
			this.applicantList.add(new Applicant("123","Neil","Nitin","Mukesh",new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"),"Mumbai",Gender.MALE,"Bachelor's in Commerce","9876543210","Indian","Car","2277"));
		}

		/**
		 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.ApplicantController#addApplicant(com.capgemini.onlinevehiclelicense.model.Applicant)}.
		 * @throws Exception 
		 * @throws JsonProcessingException 
		 */
		@Test
		void testAddApplicant() throws JsonProcessingException, Exception {
			given(applicantService.addApplicant("111",any(Applicant.class))).willAnswer((invocation) -> invocation.getArgument(0));
			Applicant applicant = new Applicant("111","First","Middle","Last",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000"),"Place",Gender.MALE,"Qualification","99999999","Indian","Car","2323");
			this.mockMvc.perform(post("/user/{username}/add-applicant-profile")
	                .contentType(MediaType.APPLICATION_JSON_UTF8)
	                .content(objectMapper.writeValueAsString(applicant)))
	                .andExpect(status().isCreated())
	                .andExpect(jsonPath("$.applicantId", is(applicant.getApplicantId())))
	                .andExpect(jsonPath("$.firstName", is(applicant.getFirstName())))
	                .andExpect(jsonPath("$.middleName", is(applicant.getMiddleName())))
	                .andExpect(jsonPath("$.lastName", is(applicant.getMiddleName())))
	                .andExpect(jsonPath("$.dateOfBirth", is(applicant.getDateOfBirth())))
	                .andExpect(jsonPath("$.placeOfBirth", is(applicant.getPlaceOfBirth())))
	                .andExpect(jsonPath("$.gender", is(applicant.getGender())))
	                .andExpect(jsonPath("$.qualification", is(applicant.getQualification())))
	                .andExpect(jsonPath("$.mobile", is(applicant.getMobile())))
	                .andExpect(jsonPath("$.nationality", is(applicant.getNationality())))
	                .andExpect(jsonPath("$.vehicleType", is(applicant.getVehicleType())))
	                .andExpect(jsonPath("$.vehicleNumber", is(applicant.getVehicleNumber())))
	                ;
		}

		/**
		 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.ApplicantController#updateApplicantDetails(com.capgemini.onlinevehiclelicense.model.Applicant)}.
		 * @throws Exception 
		 * @throws JsonProcessingException 
		 */
		@Test
		void testUpdateApplicantDetails() throws JsonProcessingException, Exception {
			Applicant applicant = new Applicant("123","Neil","Nitin","Mukesh",new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"),"Mumbai",Gender.MALE,"Bachelor's in Commerce","9876543210","Indian","Car","2277");
			 given(applicantService.viewApplicantById("123")).willReturn(null);
		        given(applicantService.updateApplicantDetails("123",any(Applicant.class))).willAnswer((invocation) -> invocation.getArgument(0));
		        this.mockMvc.perform(put("/user/{username}/update-applicant-profile", applicant.getApplicantId())
		                .contentType(MediaType.APPLICATION_JSON_UTF8)
		                .content(objectMapper.writeValueAsString(applicant)))
		                .andExpect(jsonPath("$.applicantId", is(applicant.getApplicantId())))
		                .andExpect(jsonPath("$.firstName", is(applicant.getFirstName())))
		                .andExpect(jsonPath("$.middleName", is(applicant.getMiddleName())))
		                .andExpect(jsonPath("$.lastName", is(applicant.getMiddleName())))
		                .andExpect(jsonPath("$.dateOfBirth", is(applicant.getDateOfBirth())))
		                .andExpect(jsonPath("$.placeOfBirth", is(applicant.getPlaceOfBirth())))
		                .andExpect(jsonPath("$.gender", is(applicant.getGender())))
		                .andExpect(jsonPath("$.qualification", is(applicant.getQualification())))
		                .andExpect(jsonPath("$.mobile", is(applicant.getMobile())))
		                .andExpect(jsonPath("$.nationality", is(applicant.getNationality())))
		                .andExpect(jsonPath("$.vehicleType", is(applicant.getVehicleType())))
		                .andExpect(jsonPath("$.vehicleNumber", is(applicant.getVehicleNumber())))
		                ;

		}

		/**
		 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.ApplicantController#removeApplicant(java.lang.String)}.
		 * @throws Exception 
		 */
		@Test
		void testRemoveApplicant() throws Exception {
			Applicant applicant = new Applicant("123","Neil","Nitin","Mukesh",new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"),"Mumbai",Gender.MALE,"Bachelor's in Commerce","9876543210","Indian","Car","2277");
			 given(applicantService.removeApplicant("111")).willReturn(new ResponseEntity<String>(HttpStatus.OK));
		        doNothing().when(applicantService).removeApplicant(applicant.getApplicantId());
		        this.mockMvc.perform(delete("/user/{username}/remove-applicant-profile", applicant.getApplicantId()))
		                .andExpect(status().isOk())
		                .andExpect(jsonPath("$.applicantId", is(applicant.getApplicantId())))
		                .andExpect(jsonPath("$.firstName", is(applicant.getFirstName())))
		                .andExpect(jsonPath("$.middleName", is(applicant.getMiddleName())))
		                .andExpect(jsonPath("$.lastName", is(applicant.getMiddleName())))
		                .andExpect(jsonPath("$.dateOfBirth", is(applicant.getDateOfBirth())))
		                .andExpect(jsonPath("$.placeOfBirth", is(applicant.getPlaceOfBirth())))
		                .andExpect(jsonPath("$.gender", is(applicant.getGender())))
		                .andExpect(jsonPath("$.qualification", is(applicant.getQualification())))
		                .andExpect(jsonPath("$.mobile", is(applicant.getMobile())))
		                .andExpect(jsonPath("$.nationality", is(applicant.getNationality())))
		                .andExpect(jsonPath("$.vehicleType", is(applicant.getVehicleType())))
		                .andExpect(jsonPath("$.vehicleNumber", is(applicant.getVehicleNumber())))
		                ;
		}

		/**
		 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.ApplicantController#viewApplicantById(java.lang.String)}.
		 * @throws Exception 
		 */
		@Test
		void testViewApplicantById() throws Exception {
			Applicant applicant = new Applicant("123","Neil","Nitin","Mukesh",new SimpleDateFormat("dd/MM/yyyy").parse("15/01/1982"),"Mumbai",Gender.MALE,"Bachelor's in Commerce","9876543210","Indian","Car","2277");
			 given(applicantService.viewApplicantById("123")).willReturn(applicant);

		        this.mockMvc.perform(get("/user/{username}/view-applicant-profile", "123"))
		                .andExpect(status().isOk()).andExpect(jsonPath("$.applicantId", is(applicant.getApplicantId())))
		                .andExpect(jsonPath("$.firstName", is(applicant.getFirstName())))
		                .andExpect(jsonPath("$.middleName", is(applicant.getMiddleName())))
		                .andExpect(jsonPath("$.lastName", is(applicant.getMiddleName())))
		                .andExpect(jsonPath("$.dateOfBirth", is(applicant.getDateOfBirth())))
		                .andExpect(jsonPath("$.placeOfBirth", is(applicant.getPlaceOfBirth())))
		                .andExpect(jsonPath("$.gender", is(applicant.getGender())))
		                .andExpect(jsonPath("$.qualification", is(applicant.getQualification())))
		                .andExpect(jsonPath("$.mobile", is(applicant.getMobile())))
		                .andExpect(jsonPath("$.nationality", is(applicant.getNationality())))
		                .andExpect(jsonPath("$.vehicleType", is(applicant.getVehicleType())))
		                .andExpect(jsonPath("$.vehicleNumber", is(applicant.getVehicleNumber())))
		                ;
		}

}
