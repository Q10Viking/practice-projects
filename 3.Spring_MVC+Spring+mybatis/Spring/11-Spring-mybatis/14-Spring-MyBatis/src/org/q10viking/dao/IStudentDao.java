package org.q10viking.dao;

import org.q10viking.beans.Student;
import java.util.List;

public interface IStudentDao {
	void insertStudent(Student student);
	void deleteById(int id);
	void updateStudent(Student student);
	
	List<Student> selectAllStudents();
	Student selectStudentById(int id);
}
