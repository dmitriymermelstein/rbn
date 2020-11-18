package com.blueribbon.exercise.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.blueribbon.exercise.entity.Coupon;

@Service
public class CouponService {

	private Map<Integer, Coupon> coupons = new HashMap();
	
	@PostConstruct
	private void init() {
		coupons.put(1, new Coupon(1, 25));
		coupons.put(2, new Coupon(2, 25));
		coupons.put(3, new Coupon(3, 25));
	}

	public Double getDiscount(Integer couponId, Double price) {
		Coupon coupon = coupons.get(couponId);
		
		if(coupon == null) {
			return null;
		} else {
			return price - price * coupon.getDiscount() / 100;
		}
	}
	
}
