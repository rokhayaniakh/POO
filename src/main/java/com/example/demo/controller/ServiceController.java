package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Service;
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/services")

public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public Iterable<Service> getAllService(){
        return serviceRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Service createService(@RequestBody Service service) {
        return serviceRepository.save(service);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable int id){
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("service not exist with id:" + id));
        return ResponseEntity.ok(service);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Service> updateService(@PathVariable int id,@RequestBody Service serviceDetails) {
        Service updateService = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("service not exist with id: " + id));

        updateService.setNom(serviceDetails.getNom());
        serviceRepository.save(updateService);
        return ResponseEntity.ok(updateService);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteService(@PathVariable int id){

        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("service not exist with id: " + id));

        serviceRepository.delete(service);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
