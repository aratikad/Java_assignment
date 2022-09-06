


public class ThreadDemoV3 {

	public static void main(String[] args) {
		Basket basket = new Basket();// shared resource
		
		Mango m1=new Mango("mango1","red",50);
		Mango m2=new Mango("mango2","yellow",20);
		Apple a3=new Apple();
		Apple a4=new Apple();
		Apple a5=new Apple();
		
		Apple a6=new Apple();
		

		UrbanFarmerV3 uf1 = new UrbanFarmerV3("Shasi V3", (short) 34, basket,m1);
		Thread tuf1 = new Thread(uf1);
		UrbanFarmerV3 uf2 = new UrbanFarmerV3("Manja V3", (short) 56, basket,m2);
		Thread tuf2 = new Thread(uf2);
		UrbanFarmerV3 uf3 = new UrbanFarmerV3("abc V3", (short) 56, basket,a3);
		Thread tuf3 = new Thread(uf3);
		UrbanFarmerV3 uf4 = new UrbanFarmerV3("pqr V3", (short) 56, basket,a4);
		Thread tuf4 = new Thread(uf4);
		UrbanFarmerV3 uf5 = new UrbanFarmerV3("xyz V3", (short) 56, basket,a5);
		Thread tuf5 = new Thread(uf5);
		
		UrbanFarmerV3 uf6 = new UrbanFarmerV3("AAA V3", (short) 56, basket,a6);
		Thread tuf6 = new Thread(uf6);

		/*
		 * UrbanFarmerV3 uf7 = new UrbanFarmerV3("BBB V3", (short) 56, basket,a6);
		 * Thread tuf7 = new Thread(uf7);
		 * 
		 * UrbanFarmerV3 uf8 = new UrbanFarmerV3("CCC V3", (short) 56, basket,a6);
		 * Thread tuf8 = new Thread(uf8);
		 */
		RetailerV3 retailer1 = new RetailerV3("retailer-1 V3", (short) 74, basket);
		Thread tRetailer1 = new Thread(retailer1);
		
		RetailerV3 retailer2 = new RetailerV3("retailer-2 V3", (short) 33, basket);
		Thread tRetailer2 = new Thread(retailer2);

		tuf1.start();
		tuf2.start();
		tuf3.start();
		tuf4.start();
		tuf5.start();
		
		tuf6.start();
	//	tuf7.start();
	
		//tRetailer1.start();		
	//tRetailer2.start();
		//tuf1.stop();
		//tuf2.stop();
	}

}
