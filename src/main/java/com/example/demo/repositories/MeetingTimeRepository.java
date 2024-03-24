package com.example.demo.repositories;

import com.example.demo.models.MeetingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingTimeRepository extends JpaRepository<MeetingTime, String> {

}
