package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Role;

import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/roles")

public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public Iterable<Role> getAllRole(){
        return roleRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable int id){
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("role not exist with id:" + id));
        return ResponseEntity.ok(role);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole(@PathVariable int id,@RequestBody Role roleDetails) {
        Role updateRole = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("role not exist with id: " + id));

        updateRole.setName(roleDetails.getName());
        roleRepository.save(updateRole);
        return ResponseEntity.ok(updateRole);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteRole(@PathVariable int id){

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("role not exist with id: " + id));

        roleRepository.delete(role);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
