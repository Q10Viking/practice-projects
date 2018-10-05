package org.q10viking.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	
	
	
/*	@Test
	public void testSelect01() {
		//第一次查询
		Student student1 = dao.selectStudentById(32);
		System.out.println(student1);
		//第二次查询
		Student student2 = dao.selectStudentById(32);
		System.out.println(student2);
		
	}*/
	/*
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student WHERE tid = ? 
	[DEBUG] ==> Parameters: 32(Integer)
	[TRACE] <==    Columns: tid, tname, tage, score
	[TRACE] <==        Row: 32, Q10Viking, 21, 97.5
	[DEBUG] <==      Total: 1
	Student [id=null, name=null, age=0, score=97.5]
	Student [id=null, name=null, age=0, score=97.5]
	*/

/*
	@Test
	public void testSelect02() {
		
		//第一次查询
		Student student1 = dao.selectStudentById(32);
		System.out.println(student1);
		
		//插入
		//dao.insertStudent(new Student("CIEE",112,100));
		//更新id=32的分数
		
		dao.updateStudent(new Student(32,"",0,88));
		sqlSession.commit();
		
		//第二次查询
		Student student2 = dao.selectStudentById(32);
		System.out.println(student2);
		
	}*/
	
	
	//encache二级缓存
	@Test
	public void testSelect03() {
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		//第一次查询
		Student student1 = dao.selectStudentById(32);
		System.out.println(student1);
		
		//清空一级缓存
		sqlSession.close();
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		
		//第二次查询
		Student student2 = dao.selectStudentById(32);
		System.out.println(student2);
	}
	
}
