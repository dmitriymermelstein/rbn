package com.blueribbon.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coupon {
	private Integer couponId;
	private Integer discount;
}
