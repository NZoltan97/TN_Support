package com.tnsupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsupport.model.Ticket;

public interface ITicketDAO extends JpaRepository<Ticket,Long> {
	
	public Ticket findByTicketId(long ticketId);
}
