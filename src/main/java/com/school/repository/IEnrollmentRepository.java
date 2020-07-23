package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.Enrollment;
import com.school.entity.Student;

public interface IEnrollmentRepository extends JpaRepository<Enrollment, Long>{
	Optional<Enrollment> findByFkstudentAndDate(Student fkstudent,String date);
	Boolean existsByFkstudentAndDate(Student fkstudent,String date);
}
