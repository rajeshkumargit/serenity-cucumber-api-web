package com.dummy.api.steps;

import com.dummy.api.endpoints.WebServiceEndPoints;
import com.dummy.api.requests.EmployeeDetailsRequests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.Steps;

public class dummyRestStepDefinitions {
	@Before
	public void setup(){
		WebServiceEndPoints endPoints = new WebServiceEndPoints();
    	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	}
	
	@After
	public void tearDown(){
        RestAssured.reset();
	}

	@Steps
	EmployeeDetailsRequests employeeRequests;

	@Then("receives a response code {string}")
	public void receives_a_response_code(String expCode) {
		employeeRequests.assertStatusCode(Integer.parseInt(expCode));
	}

	@Given("users requests employee details with path {string}")
	public void users_requests_employee_details_with_path(String path) {
		employeeRequests.getEmployeeDetails(path);
	}


	@Then("compares the output with the expected data {string},{string},{string},{string},{string}>")
	public void compares_the_output_with_the_expected_data(String id, String name, String age, String salary, String image) {
		employeeRequests.assertEmployeeDetailsResponse(id,name,age,salary,image);
	}

	@When("users posts employee details with path {string}")
	public void users_posts_employee_details_with_path(String path) {
		employeeRequests.postInvalidRequest(path);
	}
}
