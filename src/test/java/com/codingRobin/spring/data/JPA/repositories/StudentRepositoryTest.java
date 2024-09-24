package com.codingRobin.spring.data.JPA.repositories;

import com.codingRobin.spring.data.JPA.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Student student = Student.builder()
                .emailId("codingRobin@gmail.com")
                .firstName("robin")
                .lastName("speedy")
                .guardianName("dave")
                .guardianEmail("guardian@gmail.com")
                .guardianMobile("123456789")
                .build();
        studentRepository.save(student);
    }
}