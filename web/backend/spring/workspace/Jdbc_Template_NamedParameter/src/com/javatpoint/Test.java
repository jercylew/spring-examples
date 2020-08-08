package com.javatpoint;  

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;  

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeDao dao = (EmployeeDao)ctx.getBean("edao");
		System.out.println("Clear table before test...");
		dao.clearAll();
		
		System.out.println("Insert a record with NameParameterTemplate...");
		dao.save(new Emp1000(101, "Dona", "Trump"));
		dao.save(new Emp1000(102, "Joe", "Biden"));
		dao.save(new Emp1000(103, "Black", "Ombama"));
		dao.save(new Emp1000(104, "Shize", "Ape"));
		dao.save(new Emp1000(1053333, "Kim", "JuneUn"));
		
		System.out.println("Fetch records with RowMapper...");
		List<Emp1000> list = dao.getAllEmployeesRowMapper();
	    for(Emp1000 e : list) {
	        System.out.println(e);
	    }
				
		System.out.println("Done");
	}
}
