package org.q10viking.dao;
import java.util.List;
import org.q10viking.beans.Student;
import java.util.Map;

public interface IStudentDao {
	public void insertStudent(Student student);
	public void insertStudentCatchId(Student student);
	
	public void deleteStudentById(int id);
	
	public void updateStudent(Student student);
	
	public List<Student> selectAllStudents();
	Map<String,Object> selectAllStudentsMap();
	
	Student selectStudentById(int id);
	List<Student> selectStudentsByName(String name);
	
}
