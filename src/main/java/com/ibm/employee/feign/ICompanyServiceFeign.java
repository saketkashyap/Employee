package com.ibm.employee.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.employee.model.CompanyModel;

@FeignClient("company-service")
public interface ICompanyServiceFeign {

	@RequestMapping(value="/company/code/{code}",method=RequestMethod.GET)
	public CompanyModel getCompanyByCompanyCode(@PathVariable("code") Integer code);
}
