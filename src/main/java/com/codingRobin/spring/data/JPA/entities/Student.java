package com.codingRobin.spring.data.JPA.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor@Builder
@Table(name = "tbl_student")
public class Student {

    @Id
    private long studentId;
    private String firstName;
    private String lastName;
    private String EmailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
