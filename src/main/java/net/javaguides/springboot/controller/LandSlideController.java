package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Landslide;
import net.javaguides.springboot.model.Worker;
import net.javaguides.springboot.repository.WorkerRepository;
import net.javaguides.springboot.service.LandSlideService;
import net.javaguides.springboot.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class LandSlideController {

	@Autowired
	private LandSlideService landSlideService;


	// get all employees
	@GetMapping("/landslides")
	public List<Landslide> getAllLandSlides(){
		return landSlideService.getAllLandSlides();
	}
	
	// create employee rest api
	@PostMapping("/landslides/crop/{id}")
	public Landslide createLand(@PathVariable (value = "id") Long id,@RequestBody Landslide landslide) {

		return landSlideService.createLandSlide( id,landslide);

	}
	
	// get employee by id rest api
	@GetMapping("/landslides/{id}")
	public ResponseEntity<Landslide> getLandSlideById(@PathVariable Long id) {
		return landSlideService.getLandslidesById(id);
	}
	
	// update employee rest api
	
	@PutMapping("/landslides/{id}")
	public ResponseEntity<Landslide> updateLandSlide(@PathVariable Long id, @RequestBody Landslide landslideDetails){
		return  landSlideService.updateLandSlide(id,landslideDetails);

	}
	
	// delete employee rest api
	@DeleteMapping("/landslides/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLandSlide(@PathVariable Long id){
		return landSlideService.deletelandSlide(id);


	}
	
	
}
