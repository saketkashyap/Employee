package com.ibm.employee.util;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ibm.employee.model.CommandModel;
import com.ibm.employee.mq.MessageSender;
import com.ibm.employee.properties.RabbitMqProperties;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageSenderUtil {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	MessageSender messageSender;
	
	@Autowired
	@Qualifier("commandMsgBean")
	RabbitMqProperties commandMqProps;
	
	@Autowired
	@Qualifier("orderMsgBean")
	RabbitMqProperties orderMqProps;
	
	final String className = MessageSenderUtil.class.toString();
	
	public void createMsgObject(String messageType,Object data )
	{
		String methodName = "createMsgObject()";
		log.info(className+","+methodName);
		
		try {
		if(messageType.equalsIgnoreCase("commandMsg"))
		{
			System.out.println("routing key is::"+commandMqProps.getRoutingKey());
			
			
				sendCommandMsg(data,
						commandMqProps.getExchange(),
						commandMqProps.getRoutingKey());
		}
		else if(messageType.equalsIgnoreCase("orderMsg"))
		{
	
			sendOrderMsg(data,orderMqProps.getExchange()
					,orderMqProps.getRoutingKey());
		}
		else
		{
			throw new Exception();
		}
		}
		catch(Exception e)
		{
			log.error("not found any exchange for the messageType");
		}
	}
	
	public void sendCommandMsg(Object data,String exchange,String routingKey)
	{
		String methodName = "sendCommandMsg(Object data)";
		log.info(className+","+methodName);
		try {
			
		
		if(!(data.getClass()== CommandModel.class))
				{
			throw new Exception();
				}
		else
		{
			messageSender.sendMessage(rabbitTemplate, exchange, routingKey, data);
		}
		}
		catch(Exception e)
		{
			log.error("wrong model configured for the msg exchange");
		}
	}
	
	public void sendOrderMsg(Object data,String exchange,String routingKey)
	{
		
	}
}
