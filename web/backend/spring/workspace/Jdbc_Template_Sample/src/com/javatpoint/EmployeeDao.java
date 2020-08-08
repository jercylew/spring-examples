package com.javatpoint;

import org.springframework.jdbc.core.JdbcTemplate;  

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		this.jdbcTemplate = jdbcTemplate;  
	}

	public int saveEmployee(Emp1000 e){  
		String query="insert into emp1000 values('" + e.getId() +
				"','" + e.getFirstName()+ "','" + e.getLastName() + "')";
		return jdbcTemplate.update(query);  
	}
	
	public int updateEmployee(Emp1000 e){  
		String query = "update emp1000 set name='" + e.getFirstName() + "',salary='" + e.getLastName() +
				"' where id='" + e.getId()+"' ";
		return jdbcTemplate.update(query);  
	}
	
	public int deleteEmployee(Emp1000 e){  
		String query="delete from emp1000 where id='" + e.getId() + "' ";  
		return jdbcTemplate.update(query);  
	}
}