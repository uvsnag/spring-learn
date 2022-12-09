package com.dao;

import com.dto.Employee;
import com.mapper.EmployeeMaper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;  

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;  
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Employee> getEmployee(String id){  
		String query="select userid, username from member where userid = '" +id +"'";
		return jdbcTemplate.query(query, new EmployeeMaper());  
	}  
	
	public List<Employee> getEmployeePreparedStatementCallback (String id){  
		String query="select userid, username from member where userid = ?'";
		
		return jdbcTemplate.query(query, new EmployeeMaper());  
	}  

	
	public Boolean saveEmployeeByPreparedStatement(final Employee e) {
		String query = "insert into employee values(?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setInt(1, e.getId());
				ps.setString(2, e.getName());
				ps.setFloat(3, e.getSalary());
				return ps.execute();
			}
		});
	}

}
