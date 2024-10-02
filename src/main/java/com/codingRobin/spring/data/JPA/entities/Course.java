package com.codingRobin.spring.data.JPA.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_course", uniqueConstraints = @UniqueConstraint(
        name = "title_unique", columnNames = "course_title"))
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long courseId;
    @Column(name = "course_title", nullable = false)
    private String title;
    private int credit;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;
}
