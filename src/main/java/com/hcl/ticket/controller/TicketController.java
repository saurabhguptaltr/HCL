package com.hcl.ticket.controller;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ticket.entity.Ticket;
import com.hcl.ticket.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	TicketService service;

	@Autowired
	JmsTemplate jmstemplate;

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("insurance-queue");
	}

	@Bean
	public Queue queue1() {
		return new ActiveMQQueue("payment-queue");
	}

//	Ticket updateTicket;

	@PostMapping(path = "/createTicket", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> createTicket(@RequestBody Ticket ticket) throws Exception {
		Ticket updated = service.createTicket(ticket);
//		"2020-03-01"
		Thread.sleep(2000);
		jmstemplate.convertAndSend(queue(), updated.getTicketId());
		return new ResponseEntity<String>("Ticket Created", new HttpHeaders(), HttpStatus.OK);
	}

	@JmsListener(destination = "ticket-queue")
	public void consume(String message) {

		try {
			System.out.println("Successfully created ticket : " + message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@GetMapping("/test")
	public String test() {
		return "test";
	
	}
}