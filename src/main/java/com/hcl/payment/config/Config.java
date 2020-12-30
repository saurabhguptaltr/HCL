package com.hcl.payment.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class Config {
	@Value("${activemqurl}")
	private String activeurl;

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("ticket-queue");
	}

	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(activeurl);
		return activeMQConnectionFactory;
	}

	@Bean
	public JmsTemplate jmstemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}
}
