package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie_Servlet
 */
@WebServlet("/Cookie_Servlet")
public class Cookie_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookie_Servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie cookie1 = new Cookie("username", "apache");
		Cookie cookie2 = new Cookie("password", "tomcat");
		cookie1.setMaxAge(1000*60*60);
		cookie2.setMaxAge(1000*60*60);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		response.setContentType("text/text");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Cookie Test</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("Please click the button to see the cookies sent to you.");
		out.println("<BR>");
		out.println("<FORM METHOD=POST>");
		out.println("<INPUT TYPE=HIDDEN NAME='COMPANY VALUE='Allianz'>");
		out.println("<INPUT TYPE=SUBMIT VALUE=Submit>");
		out.println("</FORM>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/text");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Cookie Test</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		
		out.println("<H2>And, here are all the cookies.</H2>");
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie: cookies)
		{
			out.println("<B>Cookie Name:</B> " + cookie.getName() + "<BR>");
			out.println("<B>Cookie Value:</B> " + cookie.getValue() + "<BR>");
		}
		out.println("Hidden Field:" +request.getParameter("COMPANY"));
		out.println("</BODY>");
		out.println("</HTML>");
	}

}
