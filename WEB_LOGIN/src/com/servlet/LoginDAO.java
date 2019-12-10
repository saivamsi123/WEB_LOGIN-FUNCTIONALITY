package com.servlet;

import java.sql.*;
import java.util.TimeZone;

public class LoginDAO implements LoginDAOInt{
	
	static Connection conn = null;
	static ResultSet rs = null;
	static Statement st = null;
	static String dbDriver;
	static String dbUrl;
	static String dbUsername;
	static String dbPassword;
	
	public LoginDAO()
	{
		 dbDriver = "com.mysql.cj.jdbc.Driver";
		 dbUrl = "jdbc:mysql://localhost:3306/Allianz?serverTimezone=" + TimeZone.getDefault().getID();
		 dbUsername = "root";
		 dbPassword = "";
	}
	
	public static Connection getConnection()
	{
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
	
	public static LoginBean fetchDetails(LoginBean bean)
	{
		try {
			String sql = "SELECT *from login";
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				String username = rs.getString("username");
				String password = rs.getString("password");
				System.out.println(username+" "+password);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return bean;
	}
	public static LoginBean store(LoginBean bean) throws SQLException
	{
		String username = bean.getUsername();    
        String password = bean.getPassword();   
        
        String sql =
                "INSERT INTO login(username, password) VALUE ('"+username+"','"+password+"')";
        
        System.out.println("Your user name is " + username);          
        System.out.println("Your password is " + password);
        System.out.println("Query: "+sql);
        try {
	          Class.forName(dbDriver);
			  conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	          PreparedStatement pst = conn.prepareStatement(sql);
	          pst.setString(1, username);
	          pst.setString(2,  password);
	          pst.executeUpdate(sql);
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }
        
		return bean;
	}

	public boolean validate(LoginBean login) {
		String beanUsername = login.getPassword();
		String beanPassword = login.getUsername();
		boolean flag = false;
		try {
			String sql = "SELECT * from login ";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next())
			{
				String username = rs.getString("username");
				String password = rs.getString("password");
				System.out.println(username+" "+password);
				if(username.contentEquals(beanUsername))
				{
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
