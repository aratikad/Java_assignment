import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import People.Farmer;

public class Main {
	 static List <Farmer>farmersList = new ArrayList<Farmer>();
	public static void main(String[] args) {
		
	
		readFromFile();
		
	}


	public static void writeIntoFile() 
	{
		//putting the farmers into file
		
		String filePath = "C:\\Users\\Admin\\eclipse-workspace\\WeekFiveAssignment\\farmers.txt";
		// first create file object for file placed at location
		// specified by filepath
		File file = new File(filePath);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			// adding header to csv
			//String[] header = { "Name", "Class", "Marks" };
			//writer.writeNext(header);

			// add data to csv
			for(int i=0;i<8;i++) {
				Farmer temp =  Main.farmersList.get(i);
				String[] temp1 = {temp.getName(),temp.getAge(),temp.getState(),temp.getPhone()};
				writer.writeNext(temp1);
			}
			// closing writer connection
			writer.close();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void readFromFile() 
	{
		 try {
			  
		        String file = "C:\\Users\\Admin\\eclipse-workspace\\WeekFiveAssignment\\farmers.txt";
				// Create an object of filereader
		        // class with CSV file as a parameter.
		        FileReader filereader = new FileReader(file);
		  
		        // create csvReader object passing
		        // file reader as a parameter
		        CSVReader csvReader = new CSVReader(filereader);
		        String[] nextRecord;
		  
		        // we are going to read data line by line
		        while ((nextRecord = csvReader.readNext()) != null) {
		            for (String cell : nextRecord) {
		                System.out.print(cell + "\t");
		            }
		            System.out.println();
		            checkPhoneNumber(nextRecord[3]);
		        }
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		    }
	}
	
	static void checkPhoneNumber(String sourceText1) 
	{
		//String sourceText1 = "7864556464 is my number 982424612 also and also 453553500";
		Pattern pattern = Pattern.compile("^\\d{10}$");
		Matcher matcher = pattern.matcher(sourceText1);
		//System.out.println("\n Pattern " + "\b[7-9](\\d){9}\b");
		if(matcher.find()) {
			System.out.println("Phone number is valid ");
		}
		else
			System.out.println("Phone number is not valid ");
	}
	
}


