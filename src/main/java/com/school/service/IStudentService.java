package com.school.service;

import java.util.List;

import com.school.dto.Student.StudentsOneAll;
import com.school.entity.Student;
import com.school.exception.SchoolException;
import com.school.message.request.FindIdForm;
import com.school.message.request.StudentForm;
import com.school.message.request.UserForm;

public interface IStudentService {
	public String createStudent(UserForm userform) throws SchoolException;
	public List<Student> findAllStudent() throws SchoolException;
	public StudentsOneAll findbyStudent(FindIdForm findidform) throws SchoolException;
	public Student updateStudent(Student student, Long id) throws SchoolException;
    public String deleteStudent(Long id) throws SchoolException;
}
