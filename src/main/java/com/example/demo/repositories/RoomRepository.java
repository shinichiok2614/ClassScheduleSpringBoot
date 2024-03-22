package com.example.demo.repositories;

import com.example.demo.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findByRoomName(String name);
}
