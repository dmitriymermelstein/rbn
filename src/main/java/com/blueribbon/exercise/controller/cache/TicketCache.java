package com.blueribbon.exercise.controller.cache;

import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueribbon.exercise.entity.CachedTicked;
import com.blueribbon.exercise.entity.Ticket;
import com.blueribbon.exercise.repository.TicketRepository;

@Component
public class TicketCache {
	
	private static final Logger log = LoggerFactory.getLogger(TicketCache.class);
	
	@Autowired
	TicketRepository ticketRepositoty;
	
	public static Hashtable<Integer, CachedTicked> cache = new Hashtable<>();
	
	public Ticket getTicket(Integer ticketId) {
		
		Ticket ticket = cache.get(ticketId).getTicket();
		
		if(ticket == null) {
			ticket = ticketRepositoty.findTicket(ticketId);
			cache.put(ticketId, new CachedTicked(ticket, System.currentTimeMillis()));
		}
		
		return ticket;
	}

	public static void clean() {
		long currentTime = System.currentTimeMillis();
		
		for(CachedTicked ticket : cache.values()) {
			if(ticket.getTime() < currentTime) {
				log.info("Ticket {} is removed from the cache in {}", ticket.getTicket().getId(), currentTime);
				log.info("ticket " );
				cache.remove(ticket.getTicket().getId());
			}
		}
	}
}
