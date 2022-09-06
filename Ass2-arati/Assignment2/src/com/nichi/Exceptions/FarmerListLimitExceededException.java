package com.nichi.Exceptions;

public class FarmerListLimitExceededException extends Exception 
{
		
	public FarmerListLimitExceededException()  //default constructor
	{
		super();
	}
		
 public FarmerListLimitExceededException(String message) // paramaterise constructor
 {

		        System.out.println(message);
}
 
}
 

