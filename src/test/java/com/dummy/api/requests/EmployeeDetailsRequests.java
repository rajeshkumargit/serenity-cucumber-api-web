package com.dummy.api.requests;

import com.dummy.api.endpoints.WebServiceEndPoints;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.http.params.CoreConnectionPNames;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class EmployeeDetailsRequests {
    private Response response = null; //Response
    private JsonPath jp = null; //JsonPath
    private RequestSpecification requestSpec;
//    Long MAX_TIMEOUT = 30000l;
//    RestAssuredConfig config = RestAssured.config()
//            .httpClient(HttpClientConfig.httpClientConfig()
//                    .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000)
//                    .setParam(CoreConnectionPNames.SO_TIMEOUT, 10000));

	public void assertStatusCode(int expStatus) {
	 assertEquals(expStatus, response.getStatusCode());		
	}

	public void getEmployeeDetails(String path) {
	    RestAssured.registerParser("text/html", Parser.JSON);
    	RequestSpecBuilder builder = new RequestSpecBuilder();
    	builder.setBasePath(path);
    	//builder.setContentType("application/json");
    	requestSpec = builder.build();
    	requestSpec = RestAssured.given().spec(requestSpec);
    	requestSpec.log().all();
    	response = requestSpec.when().get().then().defaultParser(Parser.JSON).extract().response();
	}

	public void assertEmployeeDetailsResponse(String id, String name, String age, String salary, String image) {
    	jp = response.jsonPath().setRoot(".");
        Assert.assertEquals("Id is wrong in response",id,jp.get("jp.data.id"));
        Assert.assertEquals("age is wrong in response",age,jp.get("jp.data.employee_age"));
        Assert.assertEquals("name is wrong in response", id, jp.get("jp.data.employee_name"));
        Assert.assertEquals("salary is wrong in response", id, jp.get("jp.data.employee_salary"));
        Assert.assertEquals("image is wrong in response", id, jp.get("jp.data.profile_image"));
        
        
	}

	public void postInvalidRequest(String path) {
	    RestAssured.registerParser("text/html", Parser.JSON);
    	RequestSpecBuilder builder = new RequestSpecBuilder();
    	builder.setBasePath(path);
    	builder.setContentType("application/json");
    	requestSpec = builder.build();
    	requestSpec = RestAssured.given().spec(requestSpec);
    	requestSpec.log().all();
    	response = requestSpec.when().post().then().extract().response();		
		
	}
	
	
	
	
	

}
