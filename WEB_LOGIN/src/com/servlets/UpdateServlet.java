package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDAO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO sd = new UserDAO();
		UserBean userBean = new UserBean();
		Map map = new HashMap();
		int id = Integer.parseInt(request.getParameter("id"));
		userBean.setId(id);
		ArrayList<UserBean> arrayList1  = new ArrayList<UserBean>();
		arrayList1 = sd.updateUser(userBean);
		for(int i=0;i<arrayList1.size();i++)
		{
			map.put("id", arrayList1.get(i).getId()) ;
			map.put("username", arrayList1.get(i).getUsername()) ;
			map.put("email", arrayList1.get(i).getEmail()) ;
			map.put("password", arrayList1.get(i).getPassword());
			map.put("phoneno", arrayList1.get(i).getPhoneNo()) ;
			map.put("address", arrayList1.get(i).getAddress()) ;
		}
		//System.out.println(map.get("userDetails"));
		ArrayList list = new ArrayList();
		list.add(map);
		request.setAttribute("users", list); // Will be available as ${users} in JSP
        request.getRequestDispatcher("/Update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phoneNo = request.getParameter("pno");
		String address = request.getParameter("address");
		UserDAO sd = new UserDAO();
		UserBean userBean = new UserBean();
		userBean.setId(id);
		userBean.setEmail(email);
		userBean.setPhoneNo(phoneNo);
		userBean.setPassword(password);
		userBean.setUsername(username);
		userBean.setAddress(address);
		int i = sd.updateUserInDb(userBean);
		if(i > 0)
		{
			pw.print("Record Updated Successfully");
			pw.println("No of records updated: "+ i);
		}
		else
		{
			pw.print("There is a problem in updating Record.");
		}
		
	}

}
