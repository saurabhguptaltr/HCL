package com.hcl.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.payment.entity.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
