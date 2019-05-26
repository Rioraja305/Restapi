package com.Rest_B.BaseTest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	
	public static RequestSpecification httpreq;
	public static Response response;
	
	public Logger logger;
	
@BeforeClass
	public void setup()
	{
		logger=logger.getLogger("EmployeeRestAPI");
	
	PropertyConfigurator.configure("Log4j.properties");
	logger.setLevel(Level.DEBUG);
	//logger.setLevel(Level.ERROR);
	
		
	
	}


}
