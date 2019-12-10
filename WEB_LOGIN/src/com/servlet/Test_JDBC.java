package com.servlet;

import java.sql.*;
import java.util.*;

public class Test_JDBC {

	public static void main(String[] args) {
		Test_JDBC.getConnection();
	}
	
	public static Connection getConnection()
	{
		Connection con = null;
		Statement statement;

		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/Allianz?serverTimezone=" + TimeZone.getDefault().getID();
		String dbUsername = "root";
		String dbPassword = "";
		try {
			String sql = "SELECT *from login";
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			System.out.println(con);
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String username = rs.getString("username");
				String password = rs.getString("password");
				System.out.println(username+" "+password);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}