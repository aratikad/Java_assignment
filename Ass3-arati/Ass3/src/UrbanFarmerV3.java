

public class UrbanFarmerV3 implements Runnable {

	private String farmerName;
	private short age;
	Basket fruitBasket;
	private IFruit fruit;

	public UrbanFarmerV3(String name, short age, Basket fruitBasket,IFruit fruit) {
		this.farmerName = name;
		this.age = age;
		this.fruitBasket = fruitBasket;
		this.fruit=fruit;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public void harvest() throws InterruptedException {
		//for (int i = 0; i < 2; i++) {			
			
			System.out.printf("%s harvesting "+fruit.toString()+" fruit.. \n", this.farmerName);
			fruitBasket.addFruit(fruit);
			
			Thread.sleep(1000);// 1ms
		//}
	}

	@Override
	public void run() {
		// System.out.printf("%s printing from thread.. \n",this.farmerName);
		try {
			harvest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
