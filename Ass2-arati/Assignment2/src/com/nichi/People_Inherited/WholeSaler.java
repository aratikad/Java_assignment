package com.nichi.People_Inherited;

import java.util.LinkedList;
import java.util.List;


import com.nichi.Exceptions.FarmerListLimitExceededException;
import com.nichi.People_Interface.Person;


public class WholeSaler implements Person
{

	private String wname;
	private Long phone;
	
	
	public static int totalFarmerNo=1;
	
	
	WholeSaler()
	{
		
	}
	
	
	public WholeSaler(String wname,long phone)
	{
			this.wname=wname;
			this.phone=phone;
	}
	

	List<Farmer> farmersListC = new LinkedList<Farmer>();
	
	
	
	public void AddFarmers(Farmer farmer) throws FarmerListLimitExceededException
	{
		if(totalFarmerNo>5)
	      throw new FarmerListLimitExceededException("\n \n ....Limit is of 5 farmers only!! Cant add further   \n ");
		

		
		
		farmersListC.add(farmer);
		
		System.out.println("farmer "+totalFarmerNo+"added succesfully");
		
		totalFarmerNo++;
	}
	
	
	public void DisplayDetails()
	{
		for(Farmer f:farmersListC)
		{
			System.out.printf("\n Name:%s  Age:%d   Address:%s",f.getName(),f.getAge(),f.getAddress());
		}
		
		
	}
	
}
