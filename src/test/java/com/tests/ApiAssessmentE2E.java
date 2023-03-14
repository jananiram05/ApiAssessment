package com.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.helpers.UserServiceHelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test
public class ApiAssessmentE2E extends UserServiceHelper {
	ApiAssessmentE2E() {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeClass
	public void setuptest() {
		RestAssured.baseURI=getBaseUri();
	}
	@Test(priority = 1)
	public void tc1GetEmployee() {
		Response res=getEmployeeData();
		 pretty(res);
			statusSuccess(res, 200);
			successValidation(res);


	}
	@Test(priority = 2)
	public void tc2CreateEmployee() {
		Response res=createEmployees();
		pretty(res);

		statusSuccess(res, 200);
		successValidation(res);
	}
	
	@Test(priority = 3)
	public void tc3deleteEmployee() {
		Response res=deleteEmployee("20");
		pretty(res);

		statusSuccess(res, 200);
		successValidation(res);
	}
	@Test(priority = 3)
	public void tc4deleteEmployeewithidis0() {
		Response res=deleteEmployee("0");
		pretty(res);

		statusSuccess(res, 400);
		successValidation(res);
	}
	@Test
	public void tc5GetWithEmployeeid() {
		Response res=getEmployeeWithid("2");
		pretty(res);

		statusSuccess(res, 200);
		successValidation(res);
	}

}
