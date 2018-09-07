package com.ibm.employee.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.employee.controller.IEmployeeController;
import com.ibm.employee.model.EmployeeResponseModel;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeControllerImpl implements IEmployeeController {

	final String className = EmployeeControllerImpl.class.toString();
	List<EmployeeResponseModel> modelList = new ArrayList<>();
	public EmployeeControllerImpl()
	{
		log.info("setting some sample models");
		EmployeeResponseModel model = new EmployeeResponseModel();
		model.setId(1);
		model.setFirstName("saket");
		model.setLastName("kashyap");
		model.setCompanyCode(744);
		model.setEmailId("sak@kashy.com");
		
		EmployeeResponseModel model1 = new EmployeeResponseModel();
		model1.setId(2);
		model1.setFirstName("rahul");
		model1.setLastName("kashyap");
		model1.setCompanyCode(123);
		model1.setEmailId("rahul@kashy.com");
		
		
		
		modelList.add(model1);
		modelList.add(model);
	}
	@Override
	public ResponseEntity<List<EmployeeResponseModel>> getAllEmployees() {
		return ResponseEntity.status(HttpStatus.OK).body(modelList);
	}

	@Override
	public ResponseEntity<EmployeeResponseModel> getEmployeeById(@PathVariable Integer id) {
		
		String methodName = "getEmployeeById(Param Id)";
		
		log.info(className+","+methodName);
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
		});
		return ResponseEntity.status(HttpStatus.OK).body(model);
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
