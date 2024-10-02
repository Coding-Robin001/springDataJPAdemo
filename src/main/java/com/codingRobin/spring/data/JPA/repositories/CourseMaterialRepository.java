package com.codingRobin.spring.data.JPA.repositories;

import com.codingRobin.spring.data.JPA.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
