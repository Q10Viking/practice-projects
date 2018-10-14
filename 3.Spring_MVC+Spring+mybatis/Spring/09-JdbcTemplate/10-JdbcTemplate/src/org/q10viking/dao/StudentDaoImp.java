package org.q10viking.dao;

import java.util.List;

import org.q10viking.beans.Student;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StudentDaoImp extends JdbcDaoSupport implements IStudentDao {

	//使用JdbcTemplate进行增删，都是通过update
	@Override
	public void insertStudent(Student student) {
		String sql="INSERT INTO student(name,age) VALUES(?,?)";
		this.getJdbcTemplate().update(sql,student.getName(),student.getAge());
	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE FROM student WHERE id=?";
		this.getJdbcTemplate().update(sql, id);
	}

	@Override
	public void updateStudent(Student student) {
		String sql="UPDATE student SET name=?,age=? WHERE id=?";
		this.getJdbcTemplate().update(sql, student.getName(),student.getAge(),student.getId());
	}

	//查询简单对象
	@Override
	public List<String> selectAllStudentsNames() {
		String sql = "SELECT name FROM student";
		return this.getJdbcTemplate().queryForList(sql, String.class);
	}
	
	//查询简单对象
	@Override
	public String selectStudentNameById(int id) {
		try {
		String sql = "SELECT name FROM student WHERE id=?";
		return this.getJdbcTemplate().queryForObject(sql, String.class, id);
		}catch(Exception ex) {
			System.out.println("查询的"+id+"不存在");
		}
		return null;
	}

	@Override
	public List<Student> selectAllStudents() {
		String sql="SELECT * FROM student";
		return this.getJdbcTemplate().query(sql,new StudentRowMapper());

	}

	@Override
	public Student selectStudentById(int id) {
		String sql="SELECT * FROM student WHERE id=?";
		return this.getJdbcTemplate().queryForObject(sql, new StudentRowMapper(),id);
	}

}
