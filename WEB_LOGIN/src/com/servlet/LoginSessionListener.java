package com.servlet;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoginSessionListener implements HttpSessionListener {
	private final AtomicInteger sessionCount = new AtomicInteger();
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//HttpSessionListener.super.sessionCreated(se);
		sessionCount.incrementAndGet();
		setActiveSessionCount(se);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//HttpSessionListener.super.sessionDestroyed(se);
		sessionCount.decrementAndGet();
		setActiveSessionCount(se);
	}
	
	private void setActiveSessionCount(HttpSessionEvent se) {
		se.getSession().getServletContext()
		   .setAttribute("activeSessions", sessionCount.get());
		System.out.println("Total Active Session: " + sessionCount.get());
	}

}
