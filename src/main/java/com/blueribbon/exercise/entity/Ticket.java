package com.blueribbon.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {

	private Integer id;
	private Integer destinationId;
	private Boolean checkIn;
	private String baggages;
}
