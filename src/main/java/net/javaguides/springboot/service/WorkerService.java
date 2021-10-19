package net.javaguides.springboot.service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Worker;
import net.javaguides.springboot.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> getAllWorkers(){
        return workerRepository.findAll();
    }
    public Worker createWorker(@RequestBody Worker worker) {
        return workerRepository.save(worker);
    }

    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Worker not exist with id :" + id));
        return ResponseEntity.ok(worker);
    }

    public ResponseEntity<Worker> updateWorker(@PathVariable Long id, @RequestBody Worker workerDetails){
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Worker not exist with id :" + id));

        worker.setFirstName(workerDetails.getFirstName());
        worker.setLastName(workerDetails.getLastName());
        worker.settelePhone(workerDetails.gettelePhone());
        worker.setOccupation(workerDetails.getOccupation());

        Worker updatedWorker = workerRepository.save(worker);
        return ResponseEntity.ok(updatedWorker);
    }

    public ResponseEntity<Map<String, Boolean>> deleteWorker(@PathVariable Long id){
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Worker not exist with id :" + id));

        workerRepository.delete(worker);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
