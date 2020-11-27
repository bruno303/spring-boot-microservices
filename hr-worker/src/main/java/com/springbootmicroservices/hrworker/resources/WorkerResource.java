package com.springbootmicroservices.hrworker.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmicroservices.hrworker.entities.Worker;
import com.springbootmicroservices.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private final WorkerRepository workerRepository;

	public WorkerResource(final WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		final var workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable final Long id) {
		final var worker = workerRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(worker);
	}
}
