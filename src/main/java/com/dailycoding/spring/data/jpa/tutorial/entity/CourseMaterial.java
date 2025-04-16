package com.dailycoding.spring.data.jpa.tutorial.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId",
            nullable = false
    )
    @JsonIgnore
    private Course course;
}
