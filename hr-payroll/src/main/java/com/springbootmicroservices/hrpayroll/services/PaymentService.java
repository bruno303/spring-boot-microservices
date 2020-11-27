package com.springbootmicroservices.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springbootmicroservices.hrpayroll.entities.Payment;
import com.springbootmicroservices.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	private final RestTemplate restTemplate;

	@Value("${hr-worker.host}")
	private String workerHost;

	public PaymentService(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Payment getPayment(final long workerId, final int days) {
		final Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));

		final var worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
