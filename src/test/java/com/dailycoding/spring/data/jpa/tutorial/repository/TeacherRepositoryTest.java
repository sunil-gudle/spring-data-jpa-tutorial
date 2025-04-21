package com.dailycoding.spring.data.jpa.tutorial.repository;

import com.dailycoding.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void saveTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Rajesh")
                .lastName("Kumar")
                //.course(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}