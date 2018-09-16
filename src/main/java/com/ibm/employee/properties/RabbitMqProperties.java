package com.ibm.employee.properties;

import org.springframework.stereotype.Component;


@Component
public interface RabbitMqProperties {

	public String getExchange();
	public String getRoutingKey();
}
