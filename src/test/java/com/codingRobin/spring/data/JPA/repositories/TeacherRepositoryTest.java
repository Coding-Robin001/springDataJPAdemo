package com.codingRobin.spring.data.JPA.repositories;

import com.codingRobin.spring.data.JPA.entities.Course;
import com.codingRobin.spring.data.JPA.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseSpringBoot = Course.builder()
                .title("SpringBoot")
                .credit(4)
                .build();
        Course courseDSA = Course.builder()
                .title("DSA")
                .credit(6)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("octavia")
                .lastName("sinclair")
                .courses(List.of(courseDSA, courseSpringBoot))
                .build();
        teacherRepository.save(teacher);

    }

}