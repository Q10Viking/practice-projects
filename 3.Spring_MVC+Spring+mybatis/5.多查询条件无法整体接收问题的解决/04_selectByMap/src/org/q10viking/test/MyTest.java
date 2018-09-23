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
	
	
	
	@Test
	public void testSelect01() {
		Student student = new Student("hzz",21,97);
		Map<String,Object> map = new HashMap();
		map.put("nameCondition","Q");
		map.put("ageCondition", 22);
		map.put("student", student);
		
		List<Student> students = dao.selectStudentsByMap(map);
		for(Student stu: students) {
			System.out.println(stu);
		}
	}
	/*
	[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student WHERE tname LIKE '%' ? '%' AND tage > ? AND score > ? 
	[DEBUG] ==> Parameters: Q(String), 22(Integer), 97.0(Double)
	[TRACE] <==    Columns: tid, tname, tage, score
	[TRACE] <==        Row: 30, Q10, 23, 97.5
	[DEBUG] <==      Total: 1
	Student [id=30, name=Q10, age=23, score=97.5]
	 */
	

	@Test
	public void testSelect02() {
		List<Student> students = dao.selectStudentsByMultiConditions("Q", 20);
		for(Student stu: students) {
			System.out.println(stu);
		}
	}
		/*
			[DEBUG] ==>  Preparing: SELECT tid,tname,tage,score FROM student WHERE tname LIKE '%' ? '%' AND tage > ? 
			[DEBUG] ==> Parameters: Q(String), 20(Integer)
			[TRACE] <==    Columns: tid, tname, tage, score
			[TRACE] <==        Row: 30, Q10, 23, 97.5
			[TRACE] <==        Row: 32, Q10Viking, 21, 97.5
			[TRACE] <==        Row: 33, QH, 23, 95.0
			[DEBUG] <==      Total: 3
			Student [id=30, name=Q10, age=23, score=97.5]
			Student [id=32, name=Q10Viking, age=21, score=97.5]
			Student [id=33, name=QH, age=23, score=95.0]
		*/
}
