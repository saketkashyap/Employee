package com.ibm.employee.service;

import java.util.List;

import com.ibm.employee.entities.Employee;


public interface IEmployeeService {

	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(Integer id);
}
