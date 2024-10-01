package com.codingRobin.spring.data.JPA.repositories;

import com.codingRobin.spring.data.JPA.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
