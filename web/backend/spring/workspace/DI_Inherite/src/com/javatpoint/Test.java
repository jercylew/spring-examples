package com.javatpoint;  
  
import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;  
  
public class Test {
	public static void main(String[] args) {
		Resource r = new ClassPathResource("applicationContext.xml");  
        BeanFactory factory = new XmlBeanFactory(r);  
        
        Employee parent = (Employee)factory.getBean("e1");
        parent.show();
        
        Employee child = (Employee)factory.getBean("e2");  
        child.show();
	}
}
