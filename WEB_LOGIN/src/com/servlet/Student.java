package com.servlet;

import org.apache.log4j.Logger;

public class Student {
	
	private static final Logger LOGGER = Logger.getLogger(Student.class);
	public static void main(String[] args) {
		LOGGER.debug("This is debug message");
		LOGGER.info("This is info message");
		LOGGER.warn("This is warn message");
		LOGGER.fatal("This is fatal message");
		LOGGER.error("This is error message");
		System.out.println("Logic executed successfully......");
	}

}
