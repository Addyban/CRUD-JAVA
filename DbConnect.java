package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	
	private static Connection con = null;
	
	public static Connection getConn()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root" , "Aditya1!");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return con;
	}

}
