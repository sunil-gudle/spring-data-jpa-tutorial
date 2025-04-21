package com.dailycoding.spring.data.jpa.tutorial.repository;

import com.dailycoding.spring.data.jpa.tutorial.entity.Course;
import com.dailycoding.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    void saveCourseMaterial(){
        Course course = Course.builder()
                .courseTitle("Spring Boot")
                .credit(3)
                .build();


        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.w3school.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }
}