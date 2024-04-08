package com.dailycoding.spring.data.jpa.tutorial.repository;

import com.dailycoding.spring.data.jpa.tutorial.entity.Course;
import com.dailycoding.spring.data.jpa.tutorial.entity.Student;
import com.dailycoding.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println("Courses: " + courseList);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Mali")
                .build();

        Course course = Course.builder()
                .courseTitle("Python")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("TotalElements: " + totalElements);
        System.out.println("TotalPages: "+ totalPages);
        System.out.println("Courses: " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("courseTitle"));

        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Course: " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Rakesh")
                .lastName("Jhunjhunwala")
                .build();

        Student student = Student.builder()
                .firstName("Adam")
                .lastName("Anderson")
                .emailId("adama@gmail.com")
                .build();

        Course course = Course.builder()
                .courseTitle("AI")
                .credit(9)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}