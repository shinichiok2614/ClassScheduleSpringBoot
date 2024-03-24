package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MeetingTime {
    @Id
    private String mtId;
    private String time;
    public MeetingTime(String mtId, String time) {
        this.mtId = mtId;
        this.time = time;
    }

    public String getMtId() {
        return mtId;
    }
    public String getTime() {
        return time;
    }

    public MeetingTime() {
    }
}