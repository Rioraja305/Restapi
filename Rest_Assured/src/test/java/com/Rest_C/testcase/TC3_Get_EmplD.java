package com.Rest_C.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Rest_B.BaseTest.Baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC3_Get_EmplD extends Baseclass{
	
	int empid=10830;
	
	@Test
	void getempid() throws InterruptedException 
	{
		logger.info("Get any one id");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpreq=RestAssured.given();
		
		logger.info("Emp ID:"+ empid);
		response=httpreq.request(Method.GET,"/employee/"+empid);

		//Delete method 
		//response=httpreq.request(Method.DELETE,"/delete/"+empid);
		Thread.sleep(2000);

}
	@Test(dependsOnMethods ="getempid")
	void checkresponsebody()
		{
		String responsebody = response.getBody().asString();
		logger.info(""+responsebody);
		Assert.assertTrue(responsebody!=null);
	}
	
//	@Test
//	void checkbody()
//	{
//		String responsebody = response.getBody().asString();
//		logger.info("Get emp id res"+responsebody);
	
//	JsonPath jsonPathEvaluator = response.jsonPath();	
//		
//		String employeename = jsonPathEvaluator
//	}
}