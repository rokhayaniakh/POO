package com.example.demo.repository;

import com.example.demo.model.Patient;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface PatientRepository extends CrudRepository<Patient, Integer> {

}

