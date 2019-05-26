package com.Rest_C.testcase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Rest_A.ulitites.Restulity;
import com.Rest_B.BaseTest.Baseclass;

import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;


public class TC2_Post extends Baseclass {
	
	String empname = Restulity.empname();
	String empsal = Restulity.empsal();
	String empage = Restulity.empage();
	
@Test
void Post() throws InterruptedException 
{
	logger.info("TC1");
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	httpreq=RestAssured.given();
	
	JSONObject requestParams = new JSONObject();
	 requestParams.put("name", empname);
	 requestParams.put("salary", empsal); 
	 requestParams.put("age", empage);
	 
	 httpreq.header("Content-Type", "application/json");
	 httpreq.body(requestParams.toJSONString());
	 response = httpreq.request(Method.POST,"/create");
	 Thread.sleep(5000);
	 
	 
}
	
@Test

public void checkresponsebody()
{
	String responsebody = response.getBody().asString();
	logger.info("Post Message"+ responsebody);
	Assert.assertEquals(responsebody.contains(empname),true);
	Assert.assertEquals(responsebody.contains(empsal),true);
	Assert.assertEquals(responsebody.contains(empage),true);
	
}

	@Test
	 void getid() throws InterruptedException
	 	  { 
		  JsonPath jsonPathEvaluator = response.jsonPath();
		  String employeeID = jsonPathEvaluator.getString("id");
		  System.out.println("Employee ID:"+ employeeID);
		  Thread.sleep(2000);
		//return employeeID;
		  }
	 
}
