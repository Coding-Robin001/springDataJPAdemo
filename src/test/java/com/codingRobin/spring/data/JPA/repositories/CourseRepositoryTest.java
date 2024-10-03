package com.codingRobin.spring.data.JPA.repositories;

import com.codingRobin.spring.data.JPA.entities.Course;
import com.codingRobin.spring.data.JPA.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("list of ccourses " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("steve")
                .lastName("owen")
                .build();
        Course course = Course.builder()
                .title("ReactJS masterclass")
                .credit(3)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
}