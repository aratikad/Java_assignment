package com.nichi.People_Inherited;

import com.nichi.Exceptions.FarmerListLimitExceededException;
import com.nichi.People_Interface.Person;

public class Farmer implements Person {

	private String name;
	private int age;
	private String address;
	
	
	Farmer()
	{
		
		
	}
	
	public Farmer(String name,int age,String address) 
	{

		
		
		this.name=name;
		this.age=age;
		this.address=address;
	}

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
