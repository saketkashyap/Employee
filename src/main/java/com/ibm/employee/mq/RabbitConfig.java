package com.ibm.employee.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;





@Configuration
public class RabbitConfig {

	
	
	
	@Bean
    public TopicExchange getExchange() {
      return new TopicExchange("commandandOrderExchange");
     }
	
	@Bean
    public Queue getQueue() {
	return new Queue("commandQueue");
	}
	
	@Bean
    public Queue getQueue1() {
	return new Queue("orderQueue");
	}
	
	
	@Bean
	public Binding declareBinding() {
	return BindingBuilder.bind(getQueue()).to(getExchange()).with("commandKey");

	}
	

	@Bean
	public Binding declareBinding1() {
	return BindingBuilder.bind(getQueue1()).to(getExchange()).with("orderKey");

	}
	
	@Bean

	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {

	final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

	rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());

	return rabbitTemplate;

	}
	
	@Bean

	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {

	return new Jackson2JsonMessageConverter();

	}

	@Bean

	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {

	return new MappingJackson2MessageConverter();

	}

	@Bean

	public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {

	DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();

	factory.setMessageConverter(consumerJackson2MessageConverter());

	return factory;

	}

	public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {

	registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());

	}
}
