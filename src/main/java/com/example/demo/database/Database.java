package com.example.demo.database;

import com.example.demo.models.*;
import com.example.demo.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(RoomRepository roomRepository,
                                   MeetingTimeRepository meetingTimeRepository,
                                   InstructorRepository instructorRepository,
                                   CourseRepository courseRepository,
                                   DepartmentRepository departmentRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Room room0 = new Room("R0", "TC-410", 25);
                Room room1 = new Room("R1", "TC-411", 45);
                Room room2 = new Room("R2", "TC-412", 35);
//                System.out.println("insert data: " + roomRepository.save(room));
                logger.info("insert data: " + roomRepository.save(room0));
                logger.info("insert data: " + roomRepository.save(room1));
                logger.info("insert data: " + roomRepository.save(room2));
                MeetingTime mt0 = new MeetingTime("MT0", "07:00 - 08:00");
                MeetingTime mt1 = new MeetingTime("MT1", "08:10 - 09:10");
                MeetingTime mt2 = new MeetingTime("MT2", "09:20 - 10:20");
                MeetingTime mt3 = new MeetingTime("MT3", "10:30 - 11:30");
                logger.info("inset data: " + meetingTimeRepository.save(mt0));
                logger.info("inset data: " + meetingTimeRepository.save(mt1));
                logger.info("inset data: " + meetingTimeRepository.save(mt2));
                logger.info("inset data: " + meetingTimeRepository.save(mt3));
                Instructor instructor0 = new Instructor("I0", "Nguyen Nhat Quang");
                Instructor instructor1 = new Instructor("I1", "Nguyen Thi Oanh  ");
                Instructor instructor2 = new Instructor("I2", "Than Quang Khoat ");
                Instructor instructor3 = new Instructor("I3", "Ngo Van Linh     ");
                logger.info("insert data: " + instructorRepository.save(instructor0));
                logger.info("insert data: " + instructorRepository.save(instructor1));
                logger.info("insert data: " + instructorRepository.save(instructor2));
                logger.info("insert data: " + instructorRepository.save(instructor3));
                ArrayList<Instructor> arrayList = new ArrayList<>();
                arrayList.add(instructor0);
                arrayList.add(instructor2);

                Course course0 = new Course("IT0" , "Tri tue nhan tao", arrayList, 25);
//                Course course0 = new Course("IT0" , "Tri tue nhan tao", new ArrayList<Instructor>(Arrays.asList(instructor0, instructor2)), 25);
                Course course1 = new Course("MA0" , "Giai tich I     ", new ArrayList<Instructor>(Arrays.asList(instructor0, instructor1,instructor2)), 35);
                Course course2 = new Course("IT1" , "Co so du lieu   ", new ArrayList<Instructor>(Arrays.asList(instructor0, instructor1)), 25);
                Course course3 = new Course("MA1" , "Dai so          ", new ArrayList<Instructor>(Arrays.asList(instructor2, instructor3)), 30);
                Course course4 = new Course("MA2" , "Toan roi rac    ", new ArrayList<Instructor>(List.of(instructor3)), 35);
                Course course5 = new Course("PH0" , "Nhiet hoc       ", new ArrayList<Instructor>(Arrays.asList(instructor0, instructor2)), 45);
                Course course6 = new Course("PH1" , "Quang hoc       ", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor3)), 45);
                logger.info("insert data: "+courseRepository.save(course0));
                logger.info("insert data: "+courseRepository.save(course1));
                logger.info("insert data: "+courseRepository.save(course2));
                logger.info("insert data: "+courseRepository.save(course3));
                logger.info("insert data: "+courseRepository.save(course4));
                logger.info("insert data: "+courseRepository.save(course5));
                logger.info("insert data: "+courseRepository.save(course6));

                Department dept0 = new Department("IT" , new ArrayList<Course>(Arrays.asList(course0, course2)));
                Department dept1 = new Department("MA" , new ArrayList<Course>(Arrays.asList(course1, course3, course4)));
                Department dept2 = new Department("PH" , new ArrayList<Course>(Arrays.asList(course5, course6)));
                logger.info("insert data: "+departmentRepository.save(dept0));
                logger.info("insert data: "+departmentRepository.save(dept1));
                logger.info("insert data: "+departmentRepository.save(dept2));

            }
        };
    }
}
