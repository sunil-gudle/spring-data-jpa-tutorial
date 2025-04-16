package com.dailycoding.spring.data.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_student", uniqueConstraints = @UniqueConstraint(name = "emailid_unique", columnNames = "email_address"))
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address", nullable = false)
    private String emailId;
    @Embedded
   private Guardian guardian;
}
