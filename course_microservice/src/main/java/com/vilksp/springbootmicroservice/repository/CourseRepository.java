package com.vilksp.springbootmicroservice.repository;

import com.vilksp.springbootmicroservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Long, Course> {
}
