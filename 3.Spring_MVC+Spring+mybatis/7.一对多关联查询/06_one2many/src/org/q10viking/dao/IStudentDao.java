package org.q10viking.dao;
import java.util.List;
import org.q10viking.beans.Student;
import java.util.Map;

public interface IStudentDao {
	List<Student> selectStudentsByIf(Student student);
	List<Student> selectStudentsWhere(Student student);
	List<Student> selectStudentsChoose(Student student);
	List<Student> selectStudentsForeach(int[] ids);
	List<Student> selectStudentsForeach2(List<Integer> ids);
	List<Student> selectStudentsForeach3(List<Student> stus);
}
