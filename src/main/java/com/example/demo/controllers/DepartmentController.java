package com.example.demo.controllers;

import com.example.demo.models.Department;
import com.example.demo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Departments")
public class DepartmentController {
    @Autowired
    DepartmentRepository repository;
    @GetMapping("/getAllDepartments")
    List<Department> getAllDepartments() {
        List<Department> departments=repository.findAll();
        for (Department department : departments) {
            department.getListCourse().size();
        }
        return departments;
    }
}
