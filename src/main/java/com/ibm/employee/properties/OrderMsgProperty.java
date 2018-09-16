package com.ibm.employee.properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Qualifier("orderMsgBean")
public class OrderMsgProperty  implements RabbitMqProperties{
	
	@Value("${RabbitMq.orderMsg.exchange}")
	private String exchange;
	@Value("${RabbitMq.orderMsg.routingkey}")
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
