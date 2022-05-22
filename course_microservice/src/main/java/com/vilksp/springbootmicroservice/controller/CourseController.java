package com.vilksp.springbootmicroservice.controller;


import com.vilksp.springbootmicroservice.model.Course;
import com.vilksp.springbootmicroservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {

        return new ResponseEntity<List<Course>>(courseService.findAllCoursesToList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> createNewCourse(@RequestBody Course course) {

        return new ResponseEntity<Course>(courseService.saveCourse(course), HttpStatus.CREATED);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId) {

        return new ResponseEntity<>(courseService.deleteCourseById(courseId), HttpStatus.OK);
    }
}
