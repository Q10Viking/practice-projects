package org.q10viking.test;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Map;

import org.q10viking.beans.Student;
import org.q10viking.dao.IStudentDao;
import org.q10viking.dao.StudentDaoImp;

public class MyTest {
	
	private IStudentDao dao;

	@Before
	public void before() {
		dao = new StudentDaoImp();
	}
	
	@Test
	public void testInsert01() {
		Student student=new Student("Q10",23,97.5);
		System.out.println(student);
		dao.insertStudent(student);
	}
	
	@Test
	public void testInsert02() {
		Student student=new Student("Viking",23,97.5);
		//Student [id=null, name=Viking, age=23, score=97.5]
		System.out.println(student);
		//获取到刚刚插入到mysql数据库的id
		dao.insertStudentCatchId(student);
		//Student [id=29, name=Viking, age=23, score=97.5]
		System.out.println(student);
	}
	
	@Test
	public void testDelete01() {
		dao.deleteStudentById(24);
	}
	
	@Test
	public void testUpdate01() {
		Student student = new Student("hzz",23,98);
		student.setId(25);
		dao.updateStudent(student);
	}
	
	@Test
	public void testSelect01() {
		List<Student> students = dao.selectAllStudents();
		if(students != null) {
			for(Student stu: students) {
				System.out.println(stu);
			}
		}
	}

	@Test
	public void testSelect02() {
		Map<String,Object> map = dao.selectAllStudentsMap();
		//Student [id=25, name=hzz, age=23, score=98.0]
		System.out.println(map.get("hzz"));
	}
	
	@Test 
	public void testSelect03() {
		Student stu = dao.selectStudentById(25);
		//Student [id=25, name=hzz, age=23, score=98.0]
		System.out.println(stu);
	}
	
	@Test 
	public void testSelect04() {
		List<Student> students = dao.selectStudentsByName("Q10");
		for(Student stu: students)
			System.out.println(stu);
	}
	/*
	Student [id=20, name=Q10Viking, age=23, score=96.0]
	Student [id=21, name=Q10Viking, age=23, score=96.0]
	Student [id=22, name=Q10Viking, age=23, score=96.0]
	Student [id=23, name=Q10Viking, age=23, score=96.0]
	Student [id=26, name=Q10Viking, age=23, score=96.0]
	Student [id=27, name=Q10, age=23, score=97.5]
	Student [id=28, name=Q10Viking, age=23, score=96.0]
	*/		
}
