package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.TimeZone;

import com.bean.UserBean;
import com.dbConnection.ConnectionManager;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;


public class RegisterUserDAO {
	
	static ResultSet rs = null;
	static Statement st = null;
	static UserBean log;
	
	public RegisterUserDAO()
	{
	    log = new UserBean();
	}
	public static boolean store(UserBean log)
	{
		System.out.println("Inside store method-->LoginDAO");
		int id = log.getId();
		String username = log.getUsername();
		String password = log.getPassword();
		String email = log.getEmail();
		String phoneno = log.getPhoneNo();
		String address = log.getAddress();
		String username1 = null, password1 = null;
		Scanner sc = new Scanner(System.in);
		int records;
		int count=0;
		try(Connection conn = ConnectionManager.getConnection()) {
			if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
			String sql = "INSERT IGNORE INTO user_registration (id,username, password, email, phoneno, address) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			while(true)
			{
				ps.setInt(1, id);
				ps.setString(2, username);
				ps.setString(3, password);
				ps.setString(4, email);
				ps.setString(5, phoneno);
				ps.setString(6, address);
				records = ps.executeUpdate();
				System.out.println("Number of records inserted: "+records);
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
}
