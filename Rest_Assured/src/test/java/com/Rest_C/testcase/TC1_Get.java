package com.Rest_C.testcase;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Rest_B.BaseTest.Baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC1_Get extends Baseclass
{
	
	@BeforeClass
	void getallemployee()
	{
		logger.info("TC1");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpreq=RestAssured.given();
		response=httpreq.request(Method.GET,"/employees");
	}
	@Test
	void checkresponsebody()
		{
		String responsebody = response.getBody().asString();
		logger.info(""+responsebody);
		Assert.assertTrue(responsebody!=null);
	}
	
	@Test
	void checkStatuscode()
	{
		int statuscode = response.getStatusCode();
		logger.info(""+statuscode);
		Assert.assertEquals(statuscode,200);
	}
	
	@Test
	void checkresponsetime()
	{
		
		logger.info("******Checking Response Time********");
		long responsetime = response.getTime();
		logger.info("Response time is:"+ responsetime);
		
		if(responsetime>2000)
			logger.warn("Response time is greater than 2000");
			
			Assert.assertTrue(responsetime<10000);
			
	}
@Test
 void Checkstatusline()
 {
	logger.info("*********** Checking status Line*********");
	String statusline = response.getStatusLine();
	System.out.println(statusline);
	logger.info("Statusline:" + statusline);
	Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	
 }

@Test

void checkcontenttype()
{
	logger.info("******* Checking content type **********");
	String contenttype  = response.header("content-type");
	logger.info("Content type is:" + contenttype);
	Assert.assertEquals(contenttype, "text/html; charset=UTF-8");
	
	
}


}
