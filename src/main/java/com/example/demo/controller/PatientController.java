package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/patient")

public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public Iterable<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable  int id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(patient);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id,@RequestBody Patient patientDetails) {
        Patient updatePatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updatePatient.setNom(patientDetails.getNom());
        updatePatient.setPrenom(patientDetails.getPrenom());
        updatePatient.setAdresse(patientDetails.getAdresse());
        updatePatient.setEmail(patientDetails.getEmail());
        updatePatient.setTelephone(patientDetails.getTelephone());
        updatePatient.setDateNaissance(patientDetails.getDateNaissance());
        updatePatient.setLieuNaissance(patientDetails.getLieuNaissance());
        updatePatient.setMatricule(patientDetails.getMatricule());
        updatePatient.setService(patientDetails.getService());



        patientRepository.save(updatePatient);

        return ResponseEntity.ok(updatePatient);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable int id){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        patientRepository.delete(patient);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
