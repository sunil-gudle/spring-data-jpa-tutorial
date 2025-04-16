package com.dailycoding.spring.data.jpa.tutorial.controller;

import com.dailycoding.spring.data.jpa.tutorial.entity.Course;
import com.dailycoding.spring.data.jpa.tutorial.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    // Constructor injection
    private final CourseService courseService;

    public RestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/api/course/{id}")
    public Course getCourseByCourseid(@PathVariable Long id){
        return courseService.getCouserByCourseId(id);
    }

    @GetMapping("/api/courses")
    public List<Course> getAllCourses(Pageable pageable){
        return courseService.getAllCourses(pageable).toList();
    }

    @PostMapping("/api/course")
    public Course saveCourseDetails(@Valid @RequestBody Course course){
        return courseService.saveCourseDetails(course);

    }

}
