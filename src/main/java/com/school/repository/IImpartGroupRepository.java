package com.school.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.ImpartGroup;

@Repository
public interface IImpartGroupRepository extends JpaRepository<ImpartGroup, Long>{
	Optional<List<ImpartGroup>> findByFkdegree(Long fkdegree);
}
