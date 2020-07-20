package com.javatpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Administrator
 *
 * Demo of autowiring with factory method, to using parameters refer to https://www.baeldung.com/spring-beans-factory-methods
 */
public class Test {  
	public static void main(String[] args) {  
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Printable p = (Printable)context.getBean("p");  
	    p.print();
	}  
} 