package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.Course;
import com.school.entity.Impart;
import com.school.entity.Professor;

@Repository
public interface IImpartRepository extends JpaRepository<Impart, Long>{
	Optional<Impart> findByCourseidAndProfessorid(Course courseid,Professor professorid);
    Boolean existsByCourseidAndProfessorid(Course courseid,Professor professorid);
}
