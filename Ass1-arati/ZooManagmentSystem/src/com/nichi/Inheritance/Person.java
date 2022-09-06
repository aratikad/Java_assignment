package com.nichi.Inheritance;

import java.util.Date;

public class Person {

	
	private String name;
	private short age;
	private Date dob;
	private String address;

	static String department;
	
	public static int totalNoOfstaff=0;
	
	
	public Person()
	{
		
	}
	
	public Person(String name,int age,Date dob,String address)
	{
		this.name=name;
		this.age=(short) age;
		this.dob=dob;
		this.address=address;
		
	}
	
	
	
	
	
	
	void addNewStaff() {} ;
	void deleteStaff() {} ;
	void updateStaff() {} ;
	
	
	
}
