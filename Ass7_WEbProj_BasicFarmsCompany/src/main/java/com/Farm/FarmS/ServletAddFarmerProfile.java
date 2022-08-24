package com.Farm.FarmS;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletAddFarmerProfile")
public class ServletAddFarmerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement psmt;
	Connection conn;
   
    public ServletAddFarmerProfile() {
        super();
       
    }

	public void init(ServletConfig config) throws ServletException {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bestfarm", "root", "Aratikad@123");
			psmt = conn.prepareStatement("INSERT INTO Farmer(fname,dob,ftype) values (?,?,?)");
			
			System.out.println("Inside HomeServlet.  JDBC connection success!!");
		} catch (SQLException e) {
			System.out.println("Inside HomeServlet.  JDBC connection failed!!" + e);
		}
	}


	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
	String NameStr = request.getParameter("farmerName");
	
	pw.printf("%s",NameStr);
	
	String Type[]=request.getParameterValues("farmType");
    
	
			try {
				
				 Date date1 = null;
			
				date1 = new SimpleDateFormat("MM-dd-yyyy").parse(request.getParameter("dob"));
				
				System.out.println(date1);
			 
			  //2)Create a new DateFormat("yyyy-MM-dd") - For mySQL format
			         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			// 3)Convert my Date obj into String, and change to ("yyyy-MM-dd") format 
			          String myStringdate = sdf.format(date1); 
			//4)Convert String back to date obj 
			           Date DateOfB =(Date)sdf.parse(myStringdate);
			  
			           
			   		psmt.setString(1,NameStr);
					
					psmt.setDate(2, (java.sql.Date) DateOfB);
					
					  // java.sql.Array anArray = conn.createArrayOf("VARCHAR",Type); 	
					
				    psmt.setString(3, Arrays.toString(Type));
				    
					psmt.executeUpdate();			
					
					pw.write("<center>Added a new farmer</center>");
				        
			           
			} 
			catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

		finally {
			pw.flush();
			pw.close();
		}			
	}

	
	public void destroy() {
		System.out.println("Inside HomeServlet. I am getting destroyed.. ");
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Inside HomeServlet.  JDBC connection closing failed!!");
		}
	}	
	
}



