package com.example.demo.database;

import com.example.demo.models.Room;
import com.example.demo.repositories.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(RoomRepository roomRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Room room0 = new Room("R0", "TC-410", 25);
                Room room1 = new Room("R1", "TC-411", 45);
                Room room2 = new Room("R2", "TC-412", 35);
//                System.out.println("insert data: " + roomRepository.save(room));
                logger.info("insert data: "+roomRepository.save(room0));
                logger.info("insert data: "+roomRepository.save(room1));
                logger.info("insert data: "+roomRepository.save(room2));
            }
        };
    }
}
