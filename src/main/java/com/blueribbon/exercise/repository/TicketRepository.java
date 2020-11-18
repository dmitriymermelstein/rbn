package com.blueribbon.exercise.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.blueribbon.exercise.entity.Ticket;

@Repository
public class TicketRepository {
	
//	private Map<Integer, Map<Integer, Ticket>> ticketsByDestination = new HashMap<>();
	private Map<Integer, Ticket> ticketsById = new HashMap<>();
	
	@PostConstruct
	private void init() {
		ticketsById.put(1, new Ticket(1, 4444, false, ""));
		ticketsById.put(2, new Ticket(1, 4444, false, ""));
		ticketsById.put(3, new Ticket(1, 4444, false, ""));

//		ticketsByDestination.put(4444, ticketsById);
	}

	public Ticket findTicket(Integer id) {
		return ticketsById.get(id);
	}	
}
