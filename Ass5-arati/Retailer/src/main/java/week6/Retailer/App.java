package week6.Retailer;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

public class App 
{

    private static final String CSV_FILE_PATH= "rr.csv";
    public static void main(String[] args)
    {
    	writeDataForCustomSeparatorCSV("retailer.txt");
    	writeDataForCustomSeparatorCSV(CSV_FILE_PATH);
    	readAllDataAtOnce(CSV_FILE_PATH);
    	String jdbcUrl="jdbc:mysql://localhost:3306/amzn";
        String username="aratikad";
        String password="Arati@123";

        String filePath=CSV_FILE_PATH;

        int batchSize=10;

        Connection connection=null;


        try{
            connection= DriverManager.getConnection(jdbcUrl,username,password);
            connection.setAutoCommit(false);

            String sql="insert into retailer(name,age,region,salary) values(?,?,?,?)";

            PreparedStatement statement=connection.prepareStatement(sql);

            BufferedReader lineReader=new BufferedReader(new FileReader(filePath));

            String lineText=null;
            int count=0;

            lineReader.readLine();
            while ((lineText=lineReader.readLine())!=null){
                String[] data=lineText.split(",");

                String name=data[0];
                String age=data[1];
                String region=data[2];
                String salary=data[3];

                statement.setString(1,name);
                statement.setString(2,age);
                statement.setString(3,region);
                statement.setString(4,salary);
                statement.addBatch();
                if(count%batchSize==0){
                    statement.executeBatch();
                    count++;
                }
            }
            lineReader.close();
            statement.executeBatch();
            connection.commit();
            connection.close();
            System.out.println("Data  inserted ");

        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
   
    	public static void writeDataForCustomSeparatorCSV(String filePath)
    	{
    	  // first create file object for file placed at location
    	    // specified by filepath
    	    File file = new File(filePath);
    	  
    	    try {
    	        // create FileWriter object with file as parameter
    	        FileWriter outputfile = new FileWriter(file);
    	  
    	        // create CSVWriter with '|' as separator
    	        CSVWriter writer = new CSVWriter(outputfile, ',',
    	                                         CSVWriter.NO_QUOTE_CHARACTER,
    	                                         CSVWriter.DEFAULT_ESCAPE_CHARACTER,
    	                                         CSVWriter.DEFAULT_LINE_END);
    	  
    	        // create a List which contains String array
    	        List<String[]> data = new ArrayList<String[]>();
    	        data.add(new String[] { "sameer", "25", "AP", "987654321" });
    	        data.add(new String[] { "ruby", "31","MP", "8526656611" });
    	        data.add(new String[] { "ram", "20", "DL", "907654321" });
    	        data.add(new String[] {"sham", "21", "AA", "917654322" });
    	        data.add(new String[] {"veer", "22", "BB", "927654333" });
    	        data.add(new String[] { "yash", "23", "CC", "937654344" });
    	        data.add(new String[] { "meera", "24", "DD","947654355" });
    	        data.add(new String[] { "dev", "25","EE", "957654366" });
    	        data.add(new String[] { "meena", "26", "FF", "967654377" });
    	        data.add(new String[] { "seema", "45", "DP", "977654388" });
    	      
    	        writer.writeAll(data);
    	  
    	        // closing writer connection
    	        writer.close();
    	    }
    	    catch (IOException e) {
    	        // TODO Auto-generated catch block
    	        e.printStackTrace();
    	    }
    	}
    	public static void readAllDataAtOnce(String file)
    	{
    	    try {
    	        // Create an object of file reader
    	        // class with CSV file as a parameter.
    	        FileReader filereader = new FileReader(file);
    	  
    	        // create csvReader object and skip first Line
    	        CSVReader csvReader = new CSVReaderBuilder(filereader)
    	                                  .withSkipLines(1)
    	                                  .build();
    	        List<String[]> allData = csvReader.readAll();
    	  
    	        // print Data
    	        for (String[] row : allData) {
    	            for (String cell : row) {
    	                System.out.print(cell + "\t");
    	            }
    	            System.out.println();
    	        }
    	    }
    	    catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	}
}