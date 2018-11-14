package com.meatloaf.excel;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection() {

		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url="jdbc:mariadb://localhost:3306/whatthe";
			conn = DriverManager.getConnection(url, "ww", "33");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("¾Æ¹«Æ° ¾ÈµÊ");
		}			
		return conn;
	}
}