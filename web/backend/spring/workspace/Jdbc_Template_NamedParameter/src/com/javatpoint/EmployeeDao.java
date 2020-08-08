package com.javatpoint;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;  

public class EmployeeDao {
	private NamedParameterJdbcTemplate  jdbcTemplate;
	
	public EmployeeDao(NamedParameterJdbcTemplate template) {  
        this.jdbcTemplate = template;  
	}

	public void setJdbcTemplate (NamedParameterJdbcTemplate  jdbcTemplate) {  
		this.jdbcTemplate = jdbcTemplate;  
	}

	public void save(Emp1000 e) {
		String query = "insert into emp1000 values (:id, :firstname, :lastname)";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", e.getId());
		map.put("firstname", e.getFirstName());
		map.put("lastname", e.getLastName());

		jdbcTemplate.execute(query, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {  
				return ps.executeUpdate();  
			}
		});
	}
	
	public int clearAll() {
		String query = "delete from emp1000";
		return jdbcTemplate.update(query, new HashMap<String, Object>());
	}
	
	public List<Emp1000> getAllEmployeesRowMapper(){  
		 return jdbcTemplate.query("select * from emp1000", new HashMap<String, Object>(),
				 new RowMapper<Emp1000>(){
		    @Override
		    public Emp1000 mapRow(ResultSet rs, int rownumber) throws SQLException {
		    	System.out.println("Row: " + rownumber);
		    	
		    	Emp1000 e = new Emp1000();
		        e.setId(rs.getInt(1));
		        e.setFirstName(rs.getString(2));
		        e.setLastName(rs.getString(3));
		        
		        return e;
		    }  
		    });  
	}
}