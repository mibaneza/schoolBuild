package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.school.entity.CourseDetail;
import com.school.entity.Enrollment;
import com.school.entity.ImpartGroup;


public interface ICourseDetailRepository extends JpaRepository<CourseDetail, Long>{
	Boolean existsByImpartgroupAndEnrollment(ImpartGroup impartgroup,Enrollment enrollment);
}
