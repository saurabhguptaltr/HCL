package com.hcl.ticket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ticket.entity.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
