

import java.util.ArrayList;
import java.util.List;

public class Basket {
	List<IFruit> fruitList = new ArrayList<IFruit>();
	
	int cnt=1;
	
	public synchronized void addFruit(IFruit fruit) throws InterruptedException{
//		System.out.printf("\n Inside addFruit for int %s",i);
		
		/*
		 * while (!fruitList.isEmpty() && fruitList.size()>5) {
		 * System.out.println("basket size is greater than 5"); wait(); };
		 */
		
		if (fruitList.size()<5) {
	 
            fruitList.add(fruit);
        	cnt++;
        	notifyAll();
        } else {
            System.out.println("Cannot add more than 5 fruits to list");
        }
		
	
		//fruitList.add(fruit);
	
	}
	
	public synchronized IFruit removeFruit() throws InterruptedException{
//		System.out.printf("\n Inside removeFruit for int ");
		while (fruitList.isEmpty()) {
			wait();
		};
		
		IFruit i = fruitList.remove(0);
		notifyAll();
		
		return i;
	}
	
	public boolean isEmpty() {
		return fruitList.isEmpty();
	}
	
	
}
