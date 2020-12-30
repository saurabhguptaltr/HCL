package com.hcl.ticket.service;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ticket.entity.Ticket;
import com.hcl.ticket.repo.TicketRepository;

@Service
public class TicketService {

	@Autowired
	TicketRepository repository;

	public Ticket createTicket(Ticket ticket) throws Exception {
		ticket.setStatus("PENDING");
		ticket.setBookingDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		ticket=repository.save(ticket);
		System.out.println(ticket.toString());
		return ticket;
	}
	public Ticket updateTicket(Ticket ticket) throws Exception {
		ticket=repository.save(ticket);
		System.out.println(ticket.toString());
		return ticket;
	}

}