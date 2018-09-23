package org.q10viking.dao;
import java.util.List;
import org.q10viking.beans.Student;
import java.util.Map;

public interface IStudentDao {
	List<Student> selectStudentsByMap(Map<String,Object> map);
	
	List<Student> selectStudentsByMultiConditions(String name,int age);
}
