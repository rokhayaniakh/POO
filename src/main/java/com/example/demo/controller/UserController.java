package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        return ResponseEntity.ok(user);
    }
    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User userDetails) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id: " + id));

        updateUser.setNom(userDetails.getNom());
        updateUser.setPrenom(userDetails.getPrenom());
        updateUser.setAdresse(userDetails.getAdresse());
        updateUser.setEmail(userDetails.getEmail());
        updateUser.setTelephone(userDetails.getTelephone());
        updateUser.setUsername(userDetails.getUsername());
        updateUser.setRoles(userDetails.getRoles());
        updateUser.setService(userDetails.getService());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id: " + id));

        userRepository.delete(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
