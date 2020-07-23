package com.school.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.DayWeek;
import com.school.entity.Horary;
import com.school.entity.Hour;

@Repository
public interface IHoraryRepository extends JpaRepository<Horary, Long>{
	Optional<Horary> findByDayweekAndHours(DayWeek dayweek, Hour hours);
	Boolean existsByDayweekAndHours(DayWeek dayweek, Hour hours);
}
