package org.q10viking.service;

import org.q10viking.beans.Student;
import java.util.List;
public interface IStudentService {
	void addStudent(Student student);
	void removeStudentById(int id);
	void modifyStudent(Student student);
	
	List<String> findAllStudentsNames();
	String findStudentNameById(int id);
	
	List<Student> findAllStudents();
	Student findStudentById(int id);
	//测试Spring阶段是否正常
	void testSpring();
}
