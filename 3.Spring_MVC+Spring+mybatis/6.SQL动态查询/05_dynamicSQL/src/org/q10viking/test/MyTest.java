package org.q10viking.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
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
	public void testSelect01() {
		//测试name和age
		Student student = new Student("Q",20,97);
		//只测试age
//		Student student = new Student("",20,97);
		//都不测试
//		Student student = new Student("",0,97);
		List<Student> students = dao.selectStudentsByIf(student);
		System.out.println(students);
	}
	
	/*
	---------------------------------------------------------------------------
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student WHERE 1=1 AND tname LIKE '%' ? '%' AND tage > ? 
	[DEBUG] ==> Parameters: Q(String), 20(Integer)
	---------------------------------------------------------------------------
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student WHERE 1=1 AND tage > ? 
	[DEBUG] ==> Parameters: 20(Integer)
	
	---------------------------------------------------------------------------
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student WHERE 1=1 
	[DEBUG] ==> Parameters: 
	*/	
	
	
	@Test
	public void testSelect02() {
		//测试name和age
//		Student student = new Student("Q",20,97);
		//只测试age
//		Student student = new Student("",20,97);
		//都不测试
		Student student = new Student("",0,97);
		List<Student> students = dao.selectStudentsWhere(student);
		System.out.println(students);
	}
	
	/*
	---------------------------------------------------------------------------
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student WHERE tname LIKE '%' ? '%' AND tage > ? 
	[DEBUG] ==> Parameters: Q(String), 20(Integer)
	---------------------------------------------------------------------------
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student WHERE tage > ? 
	[DEBUG] ==> Parameters: 20(Integer)
	---------------------------------------------------------------------------
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student 
	[DEBUG] ==> Parameters: 
	*/


	@Test
	public void testSelect03() {
		//测试name和age
		Student student = new Student("Q",20,97);
		//只测试age
//		Student student = new Student("",20,97);
		//都不测试
//		Student student = new Student("",0,97);
		List<Student> students = dao.selectStudentsChoose(student);
		System.out.println(students);
	}
	
	
	/*
	---------------------------------------------------------------------------
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student WHERE tname LIKE '%' ? '%' 
	[DEBUG] ==> Parameters: Q(String)
	---------------------------------------------------------------------------
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student WHERE tage > ? 
	[DEBUG] ==> Parameters: 20(Integer)
	---------------------------------------------------------------------------
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student 
	[DEBUG] ==> Parameters: 
	*/
	
	
	@Test
	public void testSelect04() {
		//Student's id
		int[] ids= {30,32,33};
		List<Student> students = dao.selectStudentsForeach(ids);
		for(Student stu: students) {
			System.out.println(stu);
		}
		
	}
		/*	
		[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student where tid in ( ? , ? , ? ) 
		[DEBUG] ==> Parameters: 30(Integer), 32(Integer), 33(Integer)
		[TRACE] <==    Columns: tid, tname, tage, score
		[TRACE] <==        Row: 30, Q10, 23, 97.5
		[TRACE] <==        Row: 32, Q10Viking, 21, 97.5
		[TRACE] <==        Row: 33, QH, 23, 95.0
		[DEBUG] <==      Total: 3
		Student [id=30, name=Q10, age=23, score=97.5]
		Student [id=32, name=Q10Viking, age=21, score=97.5]
		Student [id=33, name=QH, age=23, score=95.0]
		*/
	
	
	
	@Test
	public void testSelect05() {
		//Student's id
		List<Integer> ids=new ArrayList();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		List<Student> students = dao.selectStudentsForeach2(ids);
		for(Student stu: students) {
			System.out.println(stu);
		}
		
	}
	/*
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student where tid in ( ? , ? , ? ) 
	[DEBUG] ==> Parameters: 1(Integer), 2(Integer), 3(Integer)
	[TRACE] <==    Columns: tid, tname, tage, score
	[TRACE] <==        Row: 1, 张三, 23, 93.5
	[TRACE] <==        Row: 2, 李四, 24, 95.5
	[TRACE] <==        Row: 3, 王五, 25, 92.5
	[DEBUG] <==      Total: 3
	Student [id=1, name=张三, age=23, score=93.5]
	Student [id=2, name=李四, age=24, score=95.5]
	Student [id=3, name=王五, age=25, score=92.5]
	*/
	
	
	
	
	@Test
	public void testSelect06() {
		//查询出id为30与32的学生信息
		Student Q10Viking = new Student();
		Q10Viking.setId(30);
		Student Q10 = new Student();
		Q10.setId(32);
		
		List<Student> stus=new ArrayList();
		stus.add(Q10Viking);
		stus.add(Q10);
		List<Student> students = dao.selectStudentsForeach3(stus);
		for(Student stu: students) {
			System.out.println(stu);
		}
	}
	
	/*
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student where tid in ( ? , ? ) 
	[DEBUG] ==> Parameters: 30(Integer), 32(Integer)
	[TRACE] <==    Columns: tid, tname, tage, score
	[TRACE] <==        Row: 30, Q10, 23, 97.5
	[TRACE] <==        Row: 32, Q10Viking, 21, 97.5
	[DEBUG] <==      Total: 2
	Student [id=30, name=Q10, age=23, score=97.5]
	Student [id=32, name=Q10Viking, age=21, score=97.5]
	*/
}
