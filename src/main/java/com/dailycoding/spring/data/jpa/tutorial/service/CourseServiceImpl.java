package com.dailycoding.spring.data.jpa.tutorial.service;

import com.dailycoding.spring.data.jpa.tutorial.entity.Course;
import com.dailycoding.spring.data.jpa.tutorial.entity.CourseMaterial;
import com.dailycoding.spring.data.jpa.tutorial.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    // Constructor Injection
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getCouserByCourseId(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()){
return course.get();
        }
        throw new RuntimeException("Course not found");
    }

    @Override
    public Page<Course> getAllCourses(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Course saveCourseDetails(Course course) {
        CourseMaterial courseMaterial = course.getCourseMaterial();
        // Link the relationship both ways before saving
        if (courseMaterial != null){
            courseMaterial.setCourse(course);
        }
        return courseRepository.save(course);
    }
}
