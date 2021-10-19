package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.springboot.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;

import net.javaguides.springboot.model.Worker;
import net.javaguides.springboot.repository.WorkerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	@Autowired
	private WorkerRepository workerRepository;
	
	// get all employees
	@GetMapping("/workers")
	public List<Worker> getAllWorkers(){
		return workerService.getAllWorkers();
	}
	
	// create employee rest api
	@PostMapping("/workers")
	public Worker createWorker(@RequestBody Worker worker) {
		return workerService.createWorker(worker);
	}
	
	// get employee by id rest api
	@GetMapping("/workers/{id}")
	public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
		return workerService.getWorkerById(id);
	}
	
	// update employee rest api
	
	@PutMapping("/workers/{id}")
	public ResponseEntity<Worker> updateWorker(@PathVariable Long id, @RequestBody Worker workerDetails){
		return  workerService.updateWorker(id,workerDetails);

	}
	
	// delete employee rest api
	@DeleteMapping("/workers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteWorker(@PathVariable Long id){
		return workerService.deleteWorker(id);


	}
	
	
}
