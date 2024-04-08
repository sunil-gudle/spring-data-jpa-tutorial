package com.dailycoding.spring.data.jpa.tutorial.repository;

import com.dailycoding.spring.data.jpa.tutorial.entity.Course;
import com.dailycoding.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDBA = Course.builder()
                .courseTitle("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .courseTitle("Java")
                .credit(5)
                .build();

        Teacher teacher= Teacher.builder()
                .firstName("Rajesh")
                .lastName("Kumar")
                //.course(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}