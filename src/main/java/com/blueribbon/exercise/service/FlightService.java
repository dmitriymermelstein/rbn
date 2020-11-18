package com.blueribbon.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueribbon.exercise.controller.cache.TicketCache;
import com.blueribbon.exercise.entity.Ticket;
import com.blueribbon.exercise.repository.TicketRepository;

@Service
public class FlightService {

	@Autowired
	TicketCache ticketCache;
	
	@Autowired
	TicketRepository ticketRepository;
	
	public Ticket getTicket(Integer id) {
		return ticketCache.getTicket(id);
	}

	public Boolean checkIn(Integer destinationId, Integer baggageId) {
		
		return null;
	}
}
