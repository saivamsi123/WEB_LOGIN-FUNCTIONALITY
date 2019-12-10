package com.servlet.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sun.jmx.snmp.Enumerated;

@WebFilter(
filterName = "RequestLogging_Filter",
urlPatterns = "/*LoginServlet",
description = "RequestLogging_Filter logs the request parameters...")

public class RequestLogging_Filter implements Filter {
	
	private ServletContext context;
	
	public RequestLogging_Filter()
	{
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException
	{
		this.context = fConfig.getServletContext();
		this.context.log("RequestLogging_Filter->init....");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("RequestLogging_Filter->->doFilter.....");
		
		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> params = req.getParameterNames();
		
		while(params.hasMoreElements())
		{
			String name = params.nextElement();
			String value = request.getParameter(name);
			this.context.log("RequestLogging_Filter->"+req.getRemoteAddr() +"::Request Params::("+name+" "+value+"");
		}
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null)
		{
			for(Cookie cookie: cookies)
			{
				this.context.log("RequestLogging_Filter->"+req.getRemoteAddr() + "::Cookie::("+cookie.getName()+" "+cookie.getValue());
			}
		}
		chain.doFilter(request, response);
	}
}
