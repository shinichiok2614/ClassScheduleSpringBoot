package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String roomId;
    private String roomName;
    private	int seatingCapacity;

    public Room() {
    }

    public Room(String roomId, String roomName, int seatingCapacity) {
        super();
        this.roomId = roomId;
        this.roomName = roomName;
        this.seatingCapacity = seatingCapacity;
    }

    public String getRoomId() {
        return roomId;
    }
    public String getRoomName() {
        return roomName;
    }
    public int getSeatingCapacity() {
        return seatingCapacity;
    }
}