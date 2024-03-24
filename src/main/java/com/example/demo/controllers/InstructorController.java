package com.example.demo.controllers;

import com.example.demo.models.Instructor;
import com.example.demo.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Instructor")
public class InstructorController {
    @Autowired
    InstructorRepository repository;
    @GetMapping("/getAllInstructor")
    List<Instructor> getAllInstructor() {
        return repository.findAll();
    }
}
