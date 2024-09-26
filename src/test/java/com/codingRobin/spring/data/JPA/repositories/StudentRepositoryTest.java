package com.codingRobin.spring.data.JPA.repositories;

import com.codingRobin.spring.data.JPA.entities.Guardian;
import com.codingRobin.spring.data.JPA.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
//                .guardianName("dave")
//                .guardianEmail("guardian@gmail.com")
//                .guardianMobile("123456789")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("guardian1@email.com")
                .mobile("8474662829")
                .name("paul")
                .build();
        Student student = Student.builder()
                .emailId("codingRobin@gmail.com")
                .firstName("robin")
                .lastName("speedy")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("robin");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("rob");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("paul");
        System.out.println("students = " + students);
    }
}