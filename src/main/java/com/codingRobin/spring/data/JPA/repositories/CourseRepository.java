package com.codingRobin.spring.data.JPA.repositories;

import com.codingRobin.spring.data.JPA.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
