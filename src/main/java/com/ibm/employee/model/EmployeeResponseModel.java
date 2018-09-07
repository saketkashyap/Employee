package com.ibm.employee.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseModel {

	private Integer id;
	private String firstName;
	private String lastName;
	private String emailId;
	private Integer companyCode;
}
