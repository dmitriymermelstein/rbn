package com.blueribbon.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CachedTicked {
	private Ticket ticket;
	private long time;
}
