package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.RegisterUserDAO;

/**
 * Servlet implementation class RegistrationServletDemo
 */
@WebServlet("/RegistrationServletDemo")
public class RegistrationServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	static Connection conn = null;
//	static ResultSet rs = null;
//	static Statement st = null;
//	static String dbDriver;
//	static String dbUrl;
//	static String dbUsername;
//	static String dbPassword;
	
    public RegistrationServletDemo() {
        super();
//        dbDriver = "com.mysql.cj.jdbc.Driver";
//		dbUrl = "jdbc:mysql://localhost:3306/Allianz?serverTimezone=" + TimeZone.getDefault().getID();
//		dbUsername = "root";
//		dbPassword = "";
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean reg = new UserBean();
		String formUser = request.getParameter("Username");
		reg.setUsername(formUser);
		String formPno = request.getParameter("phoneNo");
		reg.setPhoneNo(formPno);
		String formAddr = request.getParameter("address");
		reg.setAddress(formAddr);
		String formPass = request.getParameter("password");
		reg.setPassword(formPass);
		String formEmail = request.getParameter("email");
		reg.setEmail(formEmail);
		String username = reg.getUsername();
		String password = reg.getPassword();
		String email = reg.getEmail();
		String phoneno = reg.getPhoneNo();
		String address = reg.getAddress();
		
		RegisterUserDAO regDAO = new RegisterUserDAO();
		if(regDAO.store(reg)){
			RequestDispatcher rd = request.getRequestDispatcher("/RegistrationSuccessFul.jsp");
			rd.forward(request, response);	
			return;
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/RegistrationFailure.jsp");
			rd.forward(request, response);
			return;
		}
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
