/**
 * 
 */
package com.capgemini.onlinevehiclelicense.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.ApplicationStatus;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.model.LicenseType;
import com.capgemini.onlinevehiclelicense.model.RTOOffice;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;
import com.capgemini.onlinevehiclelicense.service.ApplicationService;
import com.capgemini.onlinevehiclelicense.service.ChallanService;
import com.capgemini.onlinevehiclelicense.service.RTOOfficeService;
import com.capgemini.onlinevehiclelicense.service.RTOOfficerService;

/**
 * @author Riddhi Das
 *
 */

@WebMvcTest(controllers = RTOOfficerController.class)
@ActiveProfiles("test")
class RTOOfficerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RTOOfficerService rtoofficerService;

	private ApplicationService applicationService;
	private ChallanService challanService;

	//private RTOOfficer rtoofficer;
	private Application application;
	private List<RTOOfficer> rtoofficerList;
	private List<Challan> challanList;

	private List<Application> applicationList;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.rtoofficerList = new ArrayList<>();
		this.rtoofficerList.add(new RTOOfficer("ram1","Ram@1234", "ram1@gmail.com"));
		this.rtoofficerList.add(new RTOOfficer("shyam123","Shyam@1234", "shyam@gmail.com"));
		this.rtoofficerList.add(new RTOOfficer("koel12","Koel@1234","koel@gmail.com"));

		this.applicationList.add(new Application("12345",new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"),"online",1500.08,"paid","all ok",ApplicationStatus.APPROVED,LicenseType.DL));
		this.applicationList.add(new Application("12645",new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"),"online",1200.00,"paid","all ok",ApplicationStatus.APPROVED,LicenseType.LL));
		this.applicationList.add(new Application("12395",new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"),"online",1300.08,"paid","all ok",ApplicationStatus.APPROVED,LicenseType.DL));


		this.applicationList.add(new Application("12145",new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"),"online",1900.08,"paid","all ok",ApplicationStatus.PENDING,LicenseType.DL));
		this.applicationList.add(new Application("12545",new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"),"online",1800.08,"due","all ok",ApplicationStatus.PENDING,LicenseType.DL));
		this.applicationList.add(new Application("12445",new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"),"online",1500.08,"paid","all ok",ApplicationStatus.PENDING,LicenseType.LL));

		this.applicationList.add(new Application("12245",new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"),"online",1500.08,"paid","all ok",ApplicationStatus.REJECTED,LicenseType.LL));
		this.applicationList.add(new Application("13345",new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"),"online",1500.08,"paid","all ok",ApplicationStatus.REJECTED,LicenseType.DL));
		this.applicationList.add(new Application("14345",new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"),"online",1500.08,"due","all ok",ApplicationStatus.REJECTED,LicenseType.LL));


	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficerController#loginUser(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testLoginUser() {




	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficerController#viewAllPendingApplications()}.
	 */
	@Test
	void testViewAllPendingApplications() throws Exception {

		given(rtoofficerService.viewAllPendingApplications()).willReturn(this.applicationList);

		this.mockMvc.perform(get("/rtoOfficer/view-pending-application"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(applicationList.size())));
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficerController#viewAllRejectedApplications()}.
	 * @throws Exception 
	 */
	@Test
	void testViewAllRejectedApplications() throws Exception {
		given(rtoofficerService.viewAllRejectedApplications()).willReturn(this.applicationList);

		this.mockMvc.perform(get("/rtoOfficer/view-rejected-application"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(applicationList.size())));

	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficerController#viewAllApprovedApplications()}.
	 * @throws Exception 
	 */
	@Test
	void testViewAllApprovedApplications() throws Exception {
		given(rtoofficerService.viewAllApprovedApplications()).willReturn(this.applicationList);

		this.mockMvc.perform(get("/rtoOfficer/view-approved-application"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(applicationList.size())));

	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficerController#viewApplicationById(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	void testViewApplicationById() throws Exception {
		String applicationNumber= "12345";
		application = new Application(applicationNumber,new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-03"),"online",1500.08,"paid","all ok",ApplicationStatus.APPROVED,LicenseType.DL);
		given(rtoofficerService.viewApplicationById(applicationNumber)).willReturn(application);


		this.mockMvc.perform(get("/rtoOfficer/view-applicationby-id/{applicationNumber}", applicationNumber))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.applicationNumber", is(application.getApplicationNumber())))
		.andExpect(jsonPath("$.applicationDate", is(application.getApplicationDate())))
		.andExpect(jsonPath("$.modeOfPayment", is(application.getModeOfPayment())))
		.andExpect(jsonPath("$.amountPaid", is(application.getAmountPaid())))
		.andExpect(jsonPath("$.applicationStatus", is(application.getApplicationStatus())))
		.andExpect(jsonPath("$.remarks", is(application.getRemarks())))
		.andExpect(jsonPath("$.appilacationStatus", is(application.getApplicationStatus())))
		.andExpect(jsonPath("$.applicationType", is(application.getApplicationType())));



	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficerController#checkChallanByVehicleNumber(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	void testCheckChallanByVehicleNumber() throws Exception {

	}	

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficerController#checkAllChallan()}.
	 * @throws Exception 
	 */
	@Test
	void testCheckAllChallan() throws Exception {
		this.challanList.add(new Challan("21-09787", "MH567L76", 500.00, "PAID"));
		this.challanList.add(new Challan("21-67853", "MH567L76", 250.00, "PAID"));
		this.challanList.add(new Challan("21-98798", "MH153C09", 1000.00, "NOT PAID"));

		given(challanService.viewAllChallanDetails()).willReturn(this.challanList);

		this.mockMvc.perform(get("/api/v1/challan/view-all-challan"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(challanList.size())));
	}


	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficerController#viewAllAppointments()}.
	 * @throws Exception 
	 */
	@Test
	void testViewAllAppointments() throws Exception {
		given(rtoofficerService.viewAllRejectedApplications()).willReturn(this.applicationList);

		this.mockMvc.perform(get("/rtoOfficer/view-all-appointment"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(applicationList.size())));
		
	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficerController#viewAllApplications()}.
	 * @throws Exception 
	 */
	@Test
	void testViewAllApplications() throws Exception {

		given(rtoofficerService.viewAllRejectedApplications()).willReturn(this.applicationList);

		this.mockMvc.perform(get("/rtoOfficer/view-all-applications"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(applicationList.size())));

	}

	/**
	 * Test method for {@link com.capgemini.onlinevehiclelicense.controller.RTOOfficerController#modifyTestResults(java.lang.String, com.capgemini.onlinevehiclelicense.model.TestResult)}.
	 */
	@Test
	void testModifyTestResults() {
		fail("Not yet implemented");
	}

}
