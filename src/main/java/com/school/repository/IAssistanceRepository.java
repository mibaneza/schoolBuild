package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.Assistance;

@Repository
public interface IAssistanceRepository extends JpaRepository<Assistance, Long>{

}
