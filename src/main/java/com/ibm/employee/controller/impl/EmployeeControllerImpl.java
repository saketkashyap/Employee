package com.ibm.employee.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.employee.controller.IEmployeeController;
import com.ibm.employee.entities.Employee;
import com.ibm.employee.model.EmployeeResponseModel;
import com.ibm.employee.service.IEmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeControllerImpl implements IEmployeeController {

	@Autowired
	IEmployeeService employeeService;
	final String className = EmployeeControllerImpl.class.toString();
	List<EmployeeResponseModel> modelList = new ArrayList<>();
	
	@Override
	public ResponseEntity<List<Employee>> getAllEmployees() {
		String methodName = "getAllEmployees";
		log.info(className+","+methodName);
		List<Employee> employeeList = employeeService.getAllEmployees();
		HttpStatus status = HttpStatus.FOUND;
		if(employeeList.size()<0)
		{
			status = HttpStatus.NOT_FOUND;
			log.info("employee information not present in the database");
		}
		
		return ResponseEntity.status(status).body(employeeList);
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		
		String methodName = "getEmployeeById(Param Id)";
		
		log.info(className+","+methodName);
		HttpStatus status = HttpStatus.OK;

		/* Keep this block of code to understand how for each works with list
		EmployeeResponseModel model = new EmployeeResponseModel();
		modelList.forEach(empployeeModel -> 
		{
			if(empployeeModel.getId() == id)
			{
				model.setCompanyCode(empployeeModel.getCompanyCode());
				model.setEmailId(empployeeModel.getEmailId());
				model.setFirstName(empployeeModel.getFirstName());
				model.setId(empployeeModel.getId());
				model.setLastName(empployeeModel.getLastName());
				
			}
		});*/
		
		Employee employee = employeeService.getEmployeeById(id);
		if(employee == null)
		{
			log.info("employee information for the given id not present in the database");
			 status = HttpStatus.NOT_FOUND;
		}
		return ResponseEntity.status(status).body(employee);
	}

	@Override
	public ResponseEntity<Object> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> getEmployeeByCompanyCode(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

}
