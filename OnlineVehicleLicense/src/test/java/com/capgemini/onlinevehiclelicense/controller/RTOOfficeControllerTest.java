/**
 * 
 */
package com.capgemini.onlinevehiclelicense.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;


import com.capgemini.onlinevehiclelicense.model.RTOOffice;
import com.capgemini.onlinevehiclelicense.service.RTOOfficeService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Riddhi Das
 *
 */

@WebMvcTest(controllers = RTOOfficeController.class)
@ActiveProfiles("test")
class RTOOfficeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RTOOfficeService rtoofficeService;


	private RTOOffice rtooffice;
	private List<RTOOffice> rtoofficeList;



	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.rtoofficeList = new ArrayList<>();
		this.rtoofficeList.add(new RTOOffice(1, "rto Office Block1"));
		this.rtoofficeList.add(new RTOOffice(2, "rto Office Block2"));
		this.rtoofficeList.add(new RTOOffice(3, "rto Office Block3"));

	}


	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficeController#viewAllRtoOffices(com.capgemini.onlinevehiclelicense.model.RTOOffice)}.
	 */
	@Test
	void testViewAllRtoOffices() throws Exception {

		given(rtoofficeService.viewAllRtoOffices()).willReturn(this.rtoofficeList);

		this.mockMvc.perform(get("/rtoOffice/view-all-rtooffices"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(rtoofficeList.size())));

	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficeController#findRtoOfficeById(int)}.
	 * @throws Exception 
	 */
	@Test
	void testFindRtoOfficeById() throws Exception {
		int rtoId= 1;
		rtooffice = new RTOOffice(rtoId, "rto Office Block1");
		given(rtoofficeService.findRtoOfficesById(rtoId)).willReturn(rtooffice);


		this.mockMvc.perform(get("/rtoOffice/find-rtooffice-byId{rto_id}", rtoId))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.rtoId", is(rtooffice.getRtoId())))
		.andExpect(jsonPath("$.rtoName", is(rtooffice.getRtoName())));
		
		

	}

}
