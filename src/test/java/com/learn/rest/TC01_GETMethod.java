package com.learn.rest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC01_GETMethod {
	@Test
	void getMethod1()
	
	{
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("StatusCode: "+response.getStatusCode());
		
		/*System.out.println("Body: "+response.getBody().prettyPrint());
		System.out.println("Cookies: "+response.getCookies());
		System.out.println("Status line:"+response.getStatusLine());
		System.out.println("Header: "+response.getHeader("Content-Type"));*/
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
		.body("data.email[1]",  equalTo("lindsay.ferguson@reqres.in"));
		
		
		
	}
	@Test
	void getMethod2()
	
	{
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
		.body("data.first_name", hasItem("Tobias"));
		
	}
	@Test
	void getMethod3()
	
	{
		
		given().header("Content-Type","application/json").
		when().get("https://reqres.in/api/users?page=2").
		then().statusCode(200)
		.body("data.first_name", hasItem("Tobias")).log().all();
		
	}
	@Test
	void deleteMethod()
	{
		
		when().delete("https://reqres.in/api/users?page=2").
		then().statusCode(204)
		.log().all();
		
	}
	

}
