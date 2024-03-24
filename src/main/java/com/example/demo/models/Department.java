package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    private String deptName;
    @ManyToMany
    @JoinTable(
            name = "department_course",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> listCourse;


    public Department() {
    }

    public Department(String deptName, List<Course> listCourse) {
        this.deptName = deptName;
        this.listCourse = listCourse;
    }

    public String getDeptName() {
        return deptName;
    }
    public List<Course> getListCourse() {
        return listCourse;
    }
}