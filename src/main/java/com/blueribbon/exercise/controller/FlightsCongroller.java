package com.blueribbon.exercise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueribbon.exercise.service.CouponService;
import com.blueribbon.exercise.service.FlightService;

@RestController
public class FlightsCongroller {

	private static final Logger log = LoggerFactory.getLogger(FlightsCongroller.class);

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private CouponService couponService;
	
	@GetMapping("/tickets")
	  public Boolean getTickets(
	  		@RequestParam Integer ticketId) {
				if(flightService.getTicket(ticketId) != null) {
					return true;	
				} else {
					return false;
				}
	  }
	
	@GetMapping("/coupon")
	  public ResponseEntity<Double> getCoupon(
	  		@RequestParam Integer couponId,
	  		@RequestParam Double price) {
		Double newPrice = couponService.getDiscount(couponId, price);
		
		if(newPrice == null) {
			return new ResponseEntity<>(price, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(newPrice, HttpStatus.OK);
		}
		
	  }
	
//	@GetMapping("/checkin")
//	  public Boolean checkin(
//	  		@RequestParam Integer destinationId,
//	  		@RequestParam Integer baggageId) {
//				return flightService.checkIn(destinationId, baggageId);
//	  }

}
