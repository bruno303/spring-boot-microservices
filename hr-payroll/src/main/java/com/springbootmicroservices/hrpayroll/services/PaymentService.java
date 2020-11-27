package com.springbootmicroservices.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springbootmicroservices.hrpayroll.entities.Payment;
import com.springbootmicroservices.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	private final WorkerFeignClient workerFeignClient;

	public PaymentService(final WorkerFeignClient workerFeignClient) {
		this.workerFeignClient = workerFeignClient;
	}

	public Payment getPayment(final long workerId, final int days) {
		final Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));

		final var worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
