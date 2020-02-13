package com.dummy.api.endpoints;

import io.restassured.RestAssured;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class WebServiceEndPoints {

    private EnvironmentVariables environmentVariables;

	public String getEndPoint() {
		environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
		String baseURL = environmentVariables.getProperty("restapi.baseurl");
    	return baseURL;
    	
    }


}

