/**
 * 
 */
package com.capgemini.onlinevehiclelicense.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.repository.IChallanRepository;

class ChallanServiceTest {
	
	@InjectMocks
	private ChallanService challanService;
	
	@MockBean
	private IChallanRepository challanRepository;
	
	private Challan challan;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		challan = new Challan("187417281", "MH735P09", 200.00, "NOT PAID");
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.service.ChallanService#payChallan(java.lang.String)}.
	 */
	@Test
	void testPayChallan() {
		String challanNumber = "187417281";
		String expectedStatus = "PAID";
		
		challan = new Challan(challanNumber, "MH735P09", 200.00, "NOT PAID");
		//challan.setStatus(expectedStatus);
		
		given(challanRepository.save(challan)).willReturn(challan);
		
		String status = challanService.payChallan(challanNumber);
		
		/*given(challanRepository.findChallan(challanNumber)).willReturn(this.challan);
		challan.setStatus(expectedStatus);
		given(challanRepository.save(this.challan)).willAnswer(invocation -> invocation.getArgument(0));*/
		
		assertThat(status)
		.isEqualTo(challan.getStatus());
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.service.ChallanService#viewAllChallanDetails()}.
	 */
	@Test
	void testViewAllChallanDetails() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.service.ChallanService#getDetailsByVehicleNumber(java.lang.String)}.
	 */
	@Test
	void testGetDetailsByVehicleNumber() {
		fail("Not yet implemented"); // TODO
	}

}
