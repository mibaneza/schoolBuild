package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.Hour;

public interface IHourRepository extends JpaRepository<Hour, Long>{

}
