package org.q10viking.service;
import java.util.List;

import org.q10viking.beans.Student;
public interface IStudentService {
	void addStudent(Student student);
	void removeById(int id);
	void modifyStudent(Student student);
	
	List<String> findAllStudentsNames();
	String findStudentNameById(int id);
	
	List<Student> findAllStudents();
	Student findStudentById(int id);
}
