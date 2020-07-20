package com.javatpoint;  
  
import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;  
  
public class Test {
	public static void main(String[] args) {
		System.out.println("=================Using BeanFactory=================");
	    Student student = getStudentV1();
	    student.displayInfo();
	    
	    System.out.println("=================Using ApplicationConext=================");
	    student = getStudentV2();
	    student.displayInfo();
	}
	
	private static Student getStudentV1() {
		//Get Student with BeanFactory
		Resource resource = new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory = new XmlBeanFactory(resource);  
	      
	    Student student = (Student)factory.getBean("studentbean");
	    
	    return student;
	}
	
	private static Student getStudentV2() {
		//Get Student with ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		Student student=(Student)context.getBean("studentbean");
	    
	    return student;
	}
}
