package dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class adminDao {
	
	public static Connection getConnection() throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return
		DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/M5-Project\", \"root\", \"123abc4d");
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

		
	}

}
