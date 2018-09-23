package org.q10viking.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Map;

import org.q10viking.beans.Student;
import org.q10viking.dao.IStudentDao;
import org.q10viking.utils.MyBatisUtils;


public class MyTest {
	
	private IStudentDao dao;
	private SqlSession sqlSession;

	@Before
	public void before() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}
	
	
	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	
	
	
	
	@Test
	public void testInsert01() {
		Student student=new Student("Q10Viking",23,97.5);
		System.out.println(student);
		dao.insertStudent(student);
		sqlSession.commit();
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
	public void testSelect03() {
		Student stu = dao.selectStudentById(30);
		//Student [id=30, name=Q10, age=23, score=97.5]
		System.out.println(stu);
	}
	

}
