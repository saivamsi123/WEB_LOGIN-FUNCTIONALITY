package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbConnection.ConnectionManager;


@WebServlet(name = "LoginServletDemo", urlPatterns = { "/LoginServletDemo" })
public class LoginServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ResultSet rs = null;
	static Statement st = null;
	static Connection conn = null;
	ConnectionManager connection = new ConnectionManager();
	public LoginServletDemo() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet------>LoginServletDemo");
		HttpSession sess = request.getSession();
		String formUser = request.getParameter("username");
		sess.setAttribute("username", formUser);
		String formPass = request.getParameter("password");
		String username = null;
		String password = null;
		try {
			conn = connection.getConnection();
			String sql = "SELECT *from user_registration";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				username = rs.getString("username");
				password = rs.getString("password");
				if(formUser.equals(username) && formPass.equals(password))
				{
					try {
						RequestDispatcher rd = request.getRequestDispatcher("/LoginSuccess.jsp");
						if(rd!=null)
						{
							rd.forward(request, response);
							return;
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				else
				{
					try {
						RequestDispatcher rd = request.getRequestDispatcher("LoginFailure.jsp");
						if(rd!=null)
						{
							rd.forward(request, response);
							return;
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				conn.close();
				st.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
