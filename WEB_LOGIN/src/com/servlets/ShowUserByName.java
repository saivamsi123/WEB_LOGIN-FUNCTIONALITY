package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDAO;

/**
 * Servlet implementation class ShowUserByName
 */
@WebServlet("/ShowUserByName")
public class ShowUserByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUserByName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean = new UserBean();
		UserBean users = null;
		Map map = new HashMap();
		UserDAO sd = new UserDAO();
		String name = request.getParameter("username");
		userBean.setUsername(name);
		ArrayList<UserBean> arrayList1 = sd.searchUserByName(userBean);
		for(int i=0;i<arrayList1.size();i++)
		{
			map.put("username", arrayList1.get(i).getUsername()) ;
			map.put("email", arrayList1.get(i).getEmail()) ;
		}
		//System.out.println(map.get("userDetails"));
		ArrayList list = new ArrayList();
		list.add(map);
		request.setAttribute("users", list); // Will be available as ${users} in JSP
        request.getRequestDispatcher("/showUserByName.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
