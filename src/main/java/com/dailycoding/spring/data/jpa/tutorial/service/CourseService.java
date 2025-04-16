package com.dailycoding.spring.data.jpa.tutorial.service;

import com.dailycoding.spring.data.jpa.tutorial.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CourseService {

    Course getCouserByCourseId(Long id);

    Page<Course> getAllCourses(Pageable pageable);

    Course saveCourseDetails(Course course);
}
