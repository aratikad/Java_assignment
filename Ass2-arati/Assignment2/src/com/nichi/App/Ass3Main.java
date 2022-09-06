package com.nichi.App;

import com.nichi.Exceptions.FarmerListLimitExceededException;
import com.nichi.People_Inherited.Farmer;
import com.nichi.People_Inherited.WholeSaler;

public class Ass3Main {

	public static void main(String[] args) throws FarmerListLimitExceededException 
	{
		
		
		
		WholeSaler ws=new WholeSaler("Arati",12345);
		
		
		Farmer f1=new Farmer("aaaa",20,"Pune");
		Farmer f2=new Farmer("baaa",21,"Mumbai");
		Farmer f3=new Farmer("caaa",22,"Delhi");
		Farmer f4=new Farmer("daaa",23,"Chennai");
		Farmer f5=new Farmer("eaaa",24,"Kulkutta");
		
		Farmer f6=new Farmer("faaa",25,"ahemdabad");
		Farmer f7=new Farmer("gaaa",26,"kashmir");
		
		
		ws.AddFarmers(f1);
		ws.AddFarmers(f2);
		ws.AddFarmers(f3);
		ws.AddFarmers(f4);
		ws.AddFarmers(f5);
		
		System.out.println("\n 5 Farmers Added Succesfully \n ");
		
		ws.DisplayDetails();
		
		ws.AddFarmers(f6);
		ws.AddFarmers(f7);
		
		ws.DisplayDetails();
	

		
		
		
		
		
		
		
	}

}
