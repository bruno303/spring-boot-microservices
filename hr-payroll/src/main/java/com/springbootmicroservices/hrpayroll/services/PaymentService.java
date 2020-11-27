package com.springbootmicroservices.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.springbootmicroservices.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(final long workerId, final int days) {
		return new Payment("Bob", 200.0, days);
	}

}
