package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/LoginServlet", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginBean loginBean = new LoginBean();
	boolean flag = false;
	LoginDAO loginDAO = new LoginDAO();
	LoginDAOInt log;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login_Servlet->doGet........");
		try {
			
			loginBean.setUsername(request.getParameter("username"));
			loginBean.setPassword(request.getParameter("password"));
			flag =  loginDAO.validate(loginBean);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			if(request.getParameter("username").equals(loginBean.getUsername()))
			{
				 String user = request.getParameter("username");
				 HttpSession session = request.getSession();
		    	 session.setAttribute("username", user );
				 out.println("<h3>Login Success</h3>");	    	 
				 out.println("Total Active Session: "+ request.getServletContext().getAttribute("activeSessions"));
				 out.println("<br/>Current User: "+ session.getAttribute("username"));
				 out.println("<form name=\"logoutForm\" method=\"POST\" action=\"logoutAction\">");
				 out.println("<br/><input type=\"submit\" value=\"Logout\"/>");
				 out.println("</form>");
			}
			else
			{
				out.println("Failed");
			}
		}
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		if(flag)
//		{
//			request.getRequestDispatcher("success.html").forward(request, response);
//		}
//		else
//		{
//			request.getRequestDispatcher("failure.html").forward(request, response);
//		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
