package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private String courseId;
    private String courseName;
    @ManyToMany
    @JoinTable(
            name = "course_instructor",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private List<Instructor> listInstructor;
//    private ArrayList<Instructor> listInstructor;
    private int maxNumbOfStudents;
    public Course() {
    }

//    public Course(String courseId, String courseName, ArrayList<Instructor> listInstructor, int maxNumbOfStudents) {
    public Course(String courseId, String courseName, List<Instructor> listInstructor, int maxNumbOfStudents) {
        super();
        this.courseId = courseId;
        this.courseName = courseName;
        this.listInstructor = listInstructor;
        this.maxNumbOfStudents = maxNumbOfStudents;
    }

    public String getCourseId() {
        return courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public List<Instructor> getListInstructor() {
        return listInstructor;
    }
    public int getMaxNumbOfStudents() {
        return maxNumbOfStudents;
    }

    @Override
    public String toString() {
        return courseName;
    }
}