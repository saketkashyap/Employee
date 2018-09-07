package com.ibm.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.employee.entities.Employee;
import com.ibm.employee.repository.IEmployeeRepository;
import com.ibm.employee.service.IEmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeRepository employeeRepo;
	
	final String className = EmployeeServiceImpl.class.toString();
	@Override
	public List<Employee> getAllEmployees() {
		String methodName ="getAllEmployees()";
		log.info(className+","+methodName);
		List<Employee> employeeList = (List<Employee>) employeeRepo.findAll();
		return employeeList;

	}
	
	@Override
	public Employee getEmployeeById(Integer id) {
		String methodName ="getEmployeeById(Integer id)";
		log.info(className+","+methodName);
		Employee employee = employeeRepo.findEmployeeById(id.longValue());
		return employee;
	}

}
