package com.Rest_C.testcase;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.Rest_A.ulitites.Restulity;
import com.Rest_B.BaseTest.Baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC4_Put_Update extends Baseclass{
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
		 response = httpreq.request(Method.PUT,"/update/"+10830);
		 Thread.sleep(5000);
		 
		 
	}
		

}
