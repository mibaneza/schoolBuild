package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.DayWeek;

public interface IDayWeekRepository extends JpaRepository<DayWeek, Long>{

}
