package org.q10viking.dao;
import java.util.List;
import org.apache.ibatis.annotations.*;
import org.q10viking.beans.Student;
import java.util.Map;

public interface IStudentDao {
	@Insert(value={"INSERT INTO student(name,age,score) VALUES(#{name},#{age},#{score}) "})
	public void insertStudent(Student student);
	
	@Insert("INSERT INTO student(name,age,score) VALUES(#{name},#{age},#{score})")
	@SelectKey(statement="SELECT @@IDENTITY", before = false, keyProperty = "id", resultType = int.class)
	public void insertStudentCatchId(Student student);
	
	@Delete(value="DELETE FROM student WHERE id=#{id} ")
	public void deleteStudentById(int id);
	
	@Update("UPDATE student SET name=#{name},age=#{age},score=#{score} WHERE id=#{id}")
	public void updateStudent(Student student);
	
	@Select("SELECT id,name,age,score FROM student")
	public List<Student> selectAllStudents();
	
	
	@Select("SELECT id,name,age,score FROM student where id=#{id}")
	Student selectStudentById(int id);
	
}
