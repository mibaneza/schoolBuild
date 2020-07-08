package com.school.repository;
//public interface IStudentRepository {}
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {
	public Student findByDni(Long dni);
	public Boolean existsByDni(Long dni);
	

	//@Query(value = "SELECT s.id FROM student AS s WHERE s.dni = :Dni;")
	//  public Long findBySqlIdStudent(@Param("Dni") long dni);
	

}
