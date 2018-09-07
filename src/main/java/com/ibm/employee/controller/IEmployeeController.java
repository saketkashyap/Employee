package com.ibm.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.employee.model.EmployeeResponseModel;

/**
 * 
 * @author saket
 *
 * This interface is responsible for exposing endpoints for employee information
 */
@RequestMapping("/employee")
public interface IEmployeeController {

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/all")
	public ResponseEntity<List<EmployeeResponseModel>> getAllEmployees();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/id/{id}",method=RequestMethod.GET)
	public ResponseEntity<EmployeeResponseModel> getEmployeeById(@PathVariable("id") Integer id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/name/{name}",method=RequestMethod.GET)
	public ResponseEntity<Object> getEmployeeByName(@PathVariable("name") String name);
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/company/{code}",method=RequestMethod.GET)
	public ResponseEntity<Object> getEmployeeByCompanyCode(@PathVariable("code") Integer code);
}
