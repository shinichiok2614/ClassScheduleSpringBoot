package com.example.demo.controllers;

import com.example.demo.models.MeetingTime;
import com.example.demo.models.ResponseObject;
import com.example.demo.repositories.MeetingTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/MeetingTimes")
public class MeetingTimeController {
    @Autowired
    private MeetingTimeRepository repository;

    @GetMapping("/getAllMeetingTimes")
    List<MeetingTime> getAllMeetingTimes() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable String id) {
        Optional<MeetingTime> foundMeetingTime = repository.findById(id);
        if (foundMeetingTime.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query meeting time successfully", foundMeetingTime)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Can not find meeting time with id = ", id)
            );
        }
    }
}
