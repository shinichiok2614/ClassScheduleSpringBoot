package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Courses")
public class CourseController {
    @Autowired
    private CourseRepository repository;
    @GetMapping("/getAllCourses")
    List<Course> getAllCourses() {
//        return repository.findAll();
        List<Course> courses = repository.findAll();
        for (Course course : courses) {
            course.getListInstructor().size(); // Trigger lazy loading
        }
        return courses;
    }
}
