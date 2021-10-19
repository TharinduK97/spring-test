package net.javaguides.springboot.service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Crop;
import net.javaguides.springboot.model.Landslide;
import net.javaguides.springboot.repository.CropRepository;
import net.javaguides.springboot.repository.LandSlideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LandSlideService {
    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private LandSlideRepository landSlideRepository;


    public List<Landslide> getAllLandSlides(){
        return landSlideRepository.findAll();
    }



    public Landslide createLandSlide(@PathVariable Long id,@RequestBody Landslide landslide) {
        
        return cropRepository.findById(id).map(crop -> {
            landslide.setCrop(crop);
            return landSlideRepository.save(landslide);
        }).orElseThrow(() -> new ResourceNotFoundException("CropId " + id + " not found"));

    }


    public ResponseEntity<Landslide> getLandslidesById(@PathVariable Long id) {
        Landslide landslide = landSlideRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LandSlide not exist with id :" + id));
        return ResponseEntity.ok(landslide);
    }

    public ResponseEntity<Landslide> updateLandSlide(@PathVariable Long id, @RequestBody Landslide landslideDetails){
        Landslide landslide = landSlideRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LandSlide not exist with id :" + id));

        landslide.setSize(landslideDetails.getSize());
        landslide.setCrop(landslideDetails.getCrop());


        Landslide  updatedlandslide1 = landSlideRepository.save(landslide);
        return ResponseEntity.ok(updatedlandslide1);
    }

        public ResponseEntity<Map<String, Boolean>> deletelandSlide(@PathVariable Long id){
        Landslide landslide = landSlideRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LandSlide not exist with id :" + id));

        landSlideRepository.delete(landslide);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
