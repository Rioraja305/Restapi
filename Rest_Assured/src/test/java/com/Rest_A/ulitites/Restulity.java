package com.Rest_A.ulitites;

import org.apache.commons.lang3.RandomStringUtils;

public class Restulity {
	
	public static String empname()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(2);
		return ("Abc:"+generatedString);
	}

	public static String empsal()
	{
		String generateString = RandomStringUtils.randomNumeric(5);
		return(generateString);
	}
	
	public static String empage()
	{
		String generatString = RandomStringUtils.randomNumeric(2);
		return(generatString);
	}
}
