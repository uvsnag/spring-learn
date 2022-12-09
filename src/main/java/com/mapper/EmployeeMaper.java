package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dto.Employee;

public class EmployeeMaper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		employee.setId(rs.getInt("userid"));
		employee.setName(rs.getString("username"));
		return employee;
	}

}
