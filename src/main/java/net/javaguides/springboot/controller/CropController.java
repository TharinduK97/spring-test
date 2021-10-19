package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Crop;
import net.javaguides.springboot.model.Worker;
import net.javaguides.springboot.repository.CropRepository;
import net.javaguides.springboot.repository.WorkerRepository;
import net.javaguides.springboot.service.CropService;
import net.javaguides.springboot.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CropController {

	@Autowired
	private CropService cropService;


	// get all employees
	@GetMapping("/crops")
	public List<Crop> getAllCrops(){
		return cropService.getAllCrops();
	}
	
	// create employee rest api
	@PostMapping("/crops")
	public Crop createCrop(@RequestBody Crop crop) {
		return cropService.createCrop(crop);
	}
	
	// get employee by id rest api
	@GetMapping("/crops/{id}")
	public ResponseEntity<Crop> getCropsById(@PathVariable Long id) {
		return cropService.getCropById(id);
	}
	
	// update employee rest api
	
	@PutMapping("/crops/{id}")
	public ResponseEntity<Crop> updateCrop(@PathVariable Long id, @RequestBody Crop cropDetails){
		return  cropService.updateCrop(id,cropDetails);

	}
	
	// delete employee rest api
	@DeleteMapping("/crops/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCrop(@PathVariable Long id){
		return cropService.deleteCrop(id);


	}
	
	
}
