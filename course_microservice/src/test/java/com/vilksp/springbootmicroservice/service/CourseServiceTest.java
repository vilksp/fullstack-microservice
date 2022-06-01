package com.vilksp.springbootmicroservice.service;

import com.vilksp.springbootmicroservice.model.Course;
import com.vilksp.springbootmicroservice.repository.CourseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    private Course course;


    @AfterEach
    void tearDown() {

        course = null;
    }

    @Test
    void getAllCourses() {

        course = Course
                .builder()
                .id(1L)
                .title("test")
                .price(10.0)
                .createTime(LocalDateTime.now())
                .subtitle("test")
                .build();

        given(courseRepository.findAll()).willReturn(List.of(course));

        List<Course> listOfCourses = courseService.findAllCoursesToList();

        assertThat(listOfCourses).isNotNull();
        assertThat(listOfCourses.size()).isEqualTo(1);
    }

    @Test
    void saveNewCourse() {
        course = Course
                .builder()
                .id(10L)
                .title("new title")
                .price(10.0)
                .createTime(LocalDateTime.now())
                .subtitle("create")
                .build();
        given(courseRepository.save(course)).willReturn(course);

        Course toTest = courseService.saveCourse(course);

        assertThat(toTest).isNotNull();

        assertThat(toTest.getId()).isEqualTo(10L);
        assertThat(toTest.getTitle()).isEqualTo("new title");
    }

    @Test
    void deleteCourseById() {
        course = Course
                .builder()
                .id(10L)
                .title("new title")
                .price(10.0)
                .createTime(LocalDateTime.now())
                .subtitle("create")
                .build();

        given(courseRepository.save(course)).willReturn(course);
        Course toTest = courseService.saveCourse(course);
        assertThat(toTest).isNotNull();

        courseService.deleteCourseById(toTest.getId());

        Optional<Course> getCourseById = courseRepository.findById(toTest.getId());

        assertThat(getCourseById.isEmpty()).isTrue();
    }
}
