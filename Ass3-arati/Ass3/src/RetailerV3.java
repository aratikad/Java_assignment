import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RetailerV3 implements Runnable {
	private String retailerName;
	private short age;
	Basket fruitBasket;

	public RetailerV3(String name, short age, Basket fruitBasket) {
		this.retailerName = name;
		this.age = age;
		this.fruitBasket = fruitBasket;
	}

	public void buyFruitsFromFarmer() throws InterruptedException, IOException {
		//for (int i = 0; i < 2; i++) {			

			IFruit fruit = fruitBasket.removeFruit();
			System.out.printf("%s bought"+fruit.toString()+"  fruit.. \n", this.retailerName);

            ObjectOutputStream os = null;
            
            try {
                os = new ObjectOutputStream(new FileOutputStream("fruits-bought.txt"));
                os.writeObject(fruit);
                System.out.println("Fruit Added");
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            } finally {
                os.close();
            
			
		} 
			
			
			Thread.sleep(1000);
		//}
	}

	@Override
	public void run() {
		try {
			buyFruitsFromFarmer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
