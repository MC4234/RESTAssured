package com.learn.rest;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class TC02_POSTPUTMethod {
	
@Test
	void postmethod() {
		
		JSONObject request = new JSONObject();
		request.put("name","Steve");
		request.put("Job","Developer");
		
		given().header("Content-Type","application/json").
		when().get("https://reqres.in/api/users?page=2").
		then().statusCode(200);
		//.body("data.first_name", hasItem("Tobias")).log().all();
		
		
		
	}

@Test
void putmethod() {
	
	JSONObject request = new JSONObject();
	request.put("name","Steve");
	request.put("Job","Developer");
	
	
	given().header("Content-Type","application/json").accept(ContentType.JSON).
	given().body(request.toJSONString()).
	when().put("https://reqres.in/api/users?page=2").
	then().statusCode(200);

	
	
	
}
	
	

}
