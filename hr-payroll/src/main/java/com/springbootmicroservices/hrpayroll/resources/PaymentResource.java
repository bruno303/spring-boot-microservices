package com.springbootmicroservices.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springbootmicroservices.hrpayroll.entities.Payment;
import com.springbootmicroservices.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	private final PaymentService paymentService;

	public PaymentResource(final PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@HystrixCommand(fallbackMethod = "getPaymentError")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable final Long workerId, @PathVariable final Integer days) {
		final var payment = paymentService.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}

	public ResponseEntity<Payment> getPaymentError(final Long workerId, final Integer days) {
		final var payment = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok(payment);
	}
}
