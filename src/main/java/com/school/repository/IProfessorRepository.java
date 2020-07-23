package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.Professor;

public interface IProfessorRepository extends JpaRepository<Professor, Long>{
	Boolean existsByNum(Long num);
	Optional<Professor> findByNum(Long num);
	
}
