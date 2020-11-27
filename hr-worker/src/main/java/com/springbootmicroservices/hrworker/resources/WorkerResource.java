package com.springbootmicroservices.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
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

	private static final Logger log = LoggerFactory.getLogger(WorkerResource.class);

	private final WorkerRepository workerRepository;
	private final Environment env;

	public WorkerResource(final WorkerRepository workerRepository, final Environment env) {
		this.workerRepository = workerRepository;
		this.env = env;
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		final var workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable final Long id) {

		log.info("PORT = {}", env.getProperty("local.server.port"));

		final var worker = workerRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(worker);
	}
}
