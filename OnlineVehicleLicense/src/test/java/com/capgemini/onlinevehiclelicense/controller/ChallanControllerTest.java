/**
 * 
 */
package com.capgemini.onlinevehiclelicense.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.service.ChallanService;
//import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ChallanController.class)
@ActiveProfiles("test")
class ChallanControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ChallanService challanService;
	
	private List<Challan> challanList;
	private List<Challan> challanByNumberList;

	@BeforeEach
	void setUp() throws Exception {
		this.challanList = new ArrayList<>();
		
		this.challanList.add(new Challan("21-09787", "MH567L76", 500.00, "PAID"));
		this.challanList.add(new Challan("21-67853", "MH567L76", 250.00, "PAID"));
		this.challanList.add(new Challan("21-98798", "MH153C09", 1000.00, "NOT PAID"));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.ChallanController#viewAllChallan()}.
	 * @throws Exception 
	 */
	@Test
	void testViewAllChallan() throws Exception {
		given(challanService.viewAllChallanDetails()).willReturn(this.challanList);
		
		this.mockMvc.perform(get("/api/v1/challan/view-all-challan"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(challanList.size())));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.ChallanController#viewChallanDetailsByVehicleNumber(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	void testViewChallanDetailsByVehicleNumber() throws Exception {
		String vehicleNumber = "MH567L76";
		this.challanByNumberList = new ArrayList<>();
		this.challanByNumberList.add(new Challan("21-09787", "MH567L76", 500.00, "PAID"));
		this.challanByNumberList.add(new Challan("21-67853", "MH567L76", 250.00, "PAID"));
		
		given(challanService.getDetailsByVehicleNumber(vehicleNumber)).willReturn(this.challanByNumberList);
		
		this.mockMvc.perform(get("/api/v1/challan/get-challan-details/{vehicleNumber}", vehicleNumber))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(challanByNumberList.size())));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.ChallanController#payChallan(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	void testPayChallan() throws Exception {
		
		String challanNumber = "21-98798";
		String status = "Paid";
		
		given(challanService.payChallan(challanNumber)).willReturn(status);
		
		this.mockMvc.perform(put("/api/v1/challan/pay-challan/{challanNumber}", challanNumber))
		.andExpect(status().isOk())
		.andExpect(content().string(status));
		
		//assertThat(returnString.getResponse().getContentAsString()).isEqualTo("Paid");
	}

}
