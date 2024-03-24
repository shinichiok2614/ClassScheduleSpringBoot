package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Instructor {
    @Id
    private String instructorId;
    private String instructorName;

    public Instructor() {
    }

    public Instructor(String instructorId, String instructorName) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
    }

    public String getInstructorId() {
        return instructorId;
    }
    public String getInstructorName() {
        return instructorName;
    }
    @Override
    public String toString() {
        return instructorName;
    }
}