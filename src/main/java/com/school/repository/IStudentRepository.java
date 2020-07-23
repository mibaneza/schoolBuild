package com.school.repository;
import java.util.Optional;

//public interface IStudentRepository {}
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.school.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {
	public Boolean existsByDni(Long dni);
	Optional<Student>findByDni(Long dni);

	//@Query(value = "SELECT s.id FROM student AS s WHERE s.dni = :Dni;")
	//  public Long findBySqlIdStudent(@Param("Dni") long dni);
	

}
