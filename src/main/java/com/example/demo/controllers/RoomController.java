package com.example.demo.controllers;

import com.example.demo.models.ResponseObject;
import com.example.demo.models.Room;
import com.example.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Rooms")
public class RoomController {
    @Autowired
    private RoomRepository repository;

    @GetMapping("/getAllRooms")
    List<Room> getAllRooms() {
//        return List.of("room1", "room2");
        return repository.findAll();
    }

    @GetMapping("/{id}")
//    obj: data, message, status
//    Room findById(@PathVariable String id) {
    ResponseEntity<ResponseObject> findById(@PathVariable String id) {
        Optional<Room> foundRoom = repository.findById(id); //Optional = co the null
        if (foundRoom.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query product successfully", foundRoom)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                    new ResponseObject("false", "Cannot find product with id = " + id, "")
                    new ResponseObject("failed", "Cannot find product with id = " + id, "")
            );
        }
//        return repository.findById(id);
//        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find product with id = " + id));
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertRoom(@RequestBody Room newRoom) {
        List<Room> foundRooms = repository.findByRoomName(newRoom.getRoomName().trim()); //bỏ " " đầu cuối
        if (!foundRooms.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Room name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Room successfully", repository.save(newRoom))
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteRoom(@PathVariable String id) {
        boolean exists = repository.existsById(id);
        if (exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete room successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find room to delete", "")
        );
    }
}
//53:48: ánh xạ jpa và sql