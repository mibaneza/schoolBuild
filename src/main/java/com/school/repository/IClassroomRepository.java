package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.Classroom;

@Repository
public interface IClassroomRepository extends JpaRepository<Classroom, Long>{
	Optional<Classroom> findBySection(String section);
	void deleteBySection(String section);
}
