package com.helpers;

import static org.hamcrest.Matchers.is;

import com.constants.Endpoints;
import com.models.CreateEmployee1Pojo;
import com.models.CreateEmployeePojo;
import com.utility.PropertiesUtility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserServiceHelper {

	static String name = null;
	static String salary = null;
	static String age = null;
	static String id = null;

	protected UserServiceHelper() {
		PropertiesUtility propertiesUtility = new PropertiesUtility();

		propertiesUtility.loadFile("applicationDataProperties");

		name = propertiesUtility.getPropertyValue("add.employee_name");
		salary = propertiesUtility.getPropertyValue("add.employee_salary");
		age = propertiesUtility.getPropertyValue("add.employee_age");
		id = propertiesUtility.getPropertyValue("add.employee_id");

	}

	public static String getBaseUri() {

		PropertiesUtility propertiesUtility = new PropertiesUtility();

		propertiesUtility.loadFile("applicationDataProperties");

		String uri = propertiesUtility.getPropertyValue("uri");

		return uri;
	}

	public static Response getEmployeeData() {
		Response res = RestAssured.given().log().headers().when().get(Endpoints.GET_EMPLOYEES);

		return res;

	}

	public static Response createEmployees() {
		CreateEmployee1Pojo createEmp = new CreateEmployee1Pojo();
		// CreateEmployeePojo createEmp = new CreateEmployeePojo();

		/*
		 * createEmp.setEmployeeAge(12); createEmp.setEmployeeName("Janani");
		 * createEmp.setEmployeeSalary(20000); createEmp.setProfileImage("");
		 * createEmp.setId(9);
		 */

		createEmp.setAge(age);
		createEmp.setName(name);
		createEmp.setSalary(salary);
		createEmp.setId(id);
		Response res = RestAssured.given().contentType(ContentType.JSON).body(createEmp).when().post(Endpoints.CREATE);

		// "{\"id\":99,\"employee_name\":\"Jan\",\"employee_salary\":340800,\"employee_age\":33,\"profile_image\":\"\"}")
		/*
		 * Response res =
		 * RestAssured.given().contentType(ContentType.JSON).body(createEmp)
		 * .when().post(Endpoints.CREATE);
		 */

		return res;
	}

	public static Response deleteEmployee(String idval) {

		Response res = RestAssured.given().pathParam("id", idval).when().delete(Endpoints.DELETE);

		return res;

	}
public static Response getEmployeeWithid(String idval) {
	Response res = RestAssured.given().pathParam("id", idval).when().get(Endpoints.EMPLOYEES_ID);

	return res;
}
	public void pretty(Response res) {
		res.prettyPrint();
	}

	public void statusSuccess(Response res, int code) {
		res.then().statusCode(code);
	}

	public void successValidation(Response res) {
		res.then().body("status", is("success"));

	}

}
