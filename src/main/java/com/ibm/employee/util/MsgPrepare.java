package com.ibm.employee.util;

import org.springframework.stereotype.Component;

import com.ibm.employee.model.CommandModel;

@Component
public class MsgPrepare {

	
	public CommandModel prepareCommandMsg(String methodName,String description,String status)
	{
		CommandModel model = new CommandModel();
		model.setCommandDesc(description);
		model.setCommandName(methodName);
		model.setStatus(status);
		return model;
	}
}
