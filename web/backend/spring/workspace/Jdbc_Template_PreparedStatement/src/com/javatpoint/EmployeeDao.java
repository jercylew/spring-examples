package com.javatpoint;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;  

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate (JdbcTemplate jdbcTemplate) {  
		this.jdbcTemplate = jdbcTemplate;  
	}

	public Boolean saveEmployeeByPreparedStatement(final Emp1000 e){
		String query = "insert into emp1000 values(?, ?, ?)";  
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>(){  
			@Override  
			public Boolean doInPreparedStatement(PreparedStatement ps)  
					throws SQLException, DataAccessException {  

				ps.setInt(1, e.getId());  
				ps.setString(2, e.getFirstName());  
				ps.setString(3, e.getLastName());  

				return ps.execute();  

			}
		});
	}
	
	public int clearAll() {
		String query = "delete from emp1000";  
		return jdbcTemplate.update(query);
	}

	public List<Emp1000> getAllEmployeesResultSetExtractor(){  
		return jdbcTemplate.query("select * from emp1000", new ResultSetExtractor<List<Emp1000>>(){  
			@Override  
			public List<Emp1000> extractData(ResultSet rs) throws SQLException,  
			DataAccessException {  
				List<Emp1000> list = new ArrayList<Emp1000>();
				
				while(rs.next()){  
					Emp1000 e = new Emp1000();
					e.setId(rs.getInt(1));  
					e.setFirstName(rs.getString(2));  
					e.setLastName(rs.getString(3));
					list.add(e);  
				}
				
				return list;  
			}  
		});  
	}
	
	public List<Emp1000> getAllEmployeesRowMapper(){  
		 return jdbcTemplate.query("select * from emp1000", new RowMapper<Emp1000>(){
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