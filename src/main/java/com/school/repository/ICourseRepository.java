package com.school.repository;
//public interface ICourseRepository{}
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
	
	Optional<Course> findByCoursename(String coursename);
	
	Boolean existsByCoursename(String coursename);

}
