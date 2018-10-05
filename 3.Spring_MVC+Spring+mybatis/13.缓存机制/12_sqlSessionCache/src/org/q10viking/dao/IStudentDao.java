package org.q10viking.dao;
import java.util.List;
import org.q10viking.beans.Student;
import java.util.Map;

public interface IStudentDao {
	void insertStudent(Student student);
	Student selectStudentById(int id);
	void updateStudent(Student student);
}
