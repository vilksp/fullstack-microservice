package com.vilksp.springbootmicroservice.service;

import com.vilksp.springbootmicroservice.model.Course;
import com.vilksp.springbootmicroservice.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course saveCourse(Course courseToSave) {

        courseToSave.setCreateTime(LocalDateTime.now());

        return courseRepository.save(courseToSave);
    }

    public List<Course> findAllCoursesToList() {

        return courseRepository.findAll();
    }

    public void deleteCourseById(Long courseId) {

        courseRepository.deleteById(courseId);
    }
}
