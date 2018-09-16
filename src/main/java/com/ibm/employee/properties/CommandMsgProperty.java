package com.ibm.employee.properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@Qualifier("commandMsgBean")
public class CommandMsgProperty implements RabbitMqProperties{

	@Value("${RabbitMq.commandMsg.exchange}")
	private String exchange;
	@Value("${RabbitMq.commandMsg.routingkey}")
	private String routingKey;
	@Override
	public String getExchange() {
		return exchange;
	}

	@Override
	public String getRoutingKey() {
		return routingKey;
	}

	
}
