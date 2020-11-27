package com.springbootmicroservices.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmicroservices.hrpayroll.entities.Payment;
import com.springbootmicroservices.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResources {

	private final PaymentService paymentService;

	public PaymentResources(final PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable final Long workerId, @PathVariable final Integer days) {
		final var payment = paymentService.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
}
