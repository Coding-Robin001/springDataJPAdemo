package com.codingRobin.spring.data.JPA.repositories;

import com.codingRobin.spring.data.JPA.entities.Course;
import com.codingRobin.spring.data.JPA.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


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

    @Test
    public void findAllPagination(){
        Pageable firstPageWithFourRecords = PageRequest.of(0, 4);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
        List<Course> courses = courseRepository.findAll(firstPageWithFourRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithFourRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithFourRecords).getTotalPages();

        System.out.println("totalPages " + totalPages);
        System.out.println("totalElements " + totalElements);
        System.out.println("Courses " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditAsc = PageRequest.of(0, 2, Sort.by("credit").ascending());
        Pageable sortByCreditAndTitle = PageRequest.of(0, 2, Sort.by("credit")
                .descending().and(Sort.by("title").ascending()));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("list of courses " + sortByTitle);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageFiveRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.
                findByTitleContaining("D", firstPageFiveRecords).getContent();

        System.out.println("list of result " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher (){

    }
}