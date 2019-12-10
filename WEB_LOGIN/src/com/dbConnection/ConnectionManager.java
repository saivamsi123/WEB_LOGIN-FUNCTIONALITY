package com.dbConnection;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnectionManager {
	private static Connection conn = null;
	private static String dbDriver = null;
	private static String dbUrl = null;
	private static String dbUsername = null;
	private static String dbPassword = null;
	
	public ConnectionManager() {
		
	}
	
	public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException 
	{
		dbDriver = "com.mysql.cj.jdbc.Driver";
		dbUrl = "jdbc:mysql://localhost:3306/Allianz?serverTimezone=" + TimeZone.getDefault().getID();
		dbUsername = "root";
		dbPassword = "";
		try {
			Class.forName(dbDriver).newInstance();
			conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Driver not Found."); 
        }
		return conn;
	}
	
	public static void closeConnection()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
