package com.javatpoint;  

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {  
	public static void main(String[] args) {  
		Resource r = new ClassPathResource("applicationContext.xml");  
		BeanFactory factory = new XmlBeanFactory(r);  

		Validator v = factory.getBean("proxy", Validator.class);  
		try {  
			v.validate(12);  
		}
		catch(Exception e) {
			System.out.println("<<<<<<<<<<<<<<<<<Exception while validation captured!>>>>>>>>>>>>>>");
			e.printStackTrace();
			System.out.println("<<<<<<<<<<<<<<<<<End of Exception Stack Trace info>>>>>>>>>>>>>>>>>");
		}
	}  
}
