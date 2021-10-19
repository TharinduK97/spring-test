package net.javaguides.springboot.service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Crop;
import net.javaguides.springboot.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CropService {
    @Autowired
    private CropRepository cropRepository;

    public List<Crop> getAllCrops(){
        return cropRepository.findAll();
    }
    public Crop createCrop(@RequestBody Crop crop) {
        return cropRepository.save(crop);
    }

    public ResponseEntity<Crop> getWorkerById(@PathVariable Long id) {
        Crop crop = cropRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Crop not exist with id :" + id));
        return ResponseEntity.ok(crop);
    }

    public ResponseEntity<Crop> updateCrop(@PathVariable Long id, @RequestBody Crop cropDetails){
        Crop crop = cropRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Crop not exist with id :" + id));

        crop.setCropName(cropDetails.getCropName());
        crop.setCropType(cropDetails.getCropType());
        crop.setLandslides(cropDetails.getLandslides());
        crop.setStartDate(cropDetails.getStartDate());

        Crop updatedCrop = cropRepository.save(crop);
        return ResponseEntity.ok(updatedCrop);
    }

    public ResponseEntity<Map<String, Boolean>> deleteCrop(@PathVariable Long id){
        Crop crop = cropRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Crop not exist with id :" + id));

        cropRepository.delete(crop);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
