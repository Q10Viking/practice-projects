package org.q10viking.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.q10viking.beans.NewsLabel;
import org.q10viking.beans.Student;
import org.q10viking.dao.IStudentDao;
import org.q10viking.utils.MyBatisUtils;
import java.util.List;
public class MyTest {
	
	private SqlSession sqlSession;
	private IStudentDao dao;
	@Before
	public void before() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}
	
	@After
	public void after() {
		sqlSession.close();
	}
	//查询父栏目
	@Test
	public void test01() {
		Student stu = dao.selectStudentById(1);
		System.out.println(stu);
	}
	/*
		[DEBUG] ==>  Preparing: SELECT sid,sname,cid,cname FROM student,middle,course WHERE sid=studentId and cid=courseId and sid=? 
		[DEBUG] ==> Parameters: 1(Integer)
		[TRACE] <==    Columns: sid, sname, cid, cname
		[TRACE] <==        Row: 1, Q10Viking, 1, JavaSE
		[TRACE] <==        Row: 1, Q10Viking, 2, JavaEE
		[DEBUG] <==      Total: 2
		Student [sid=1, sname=Q10Viking, courses=[Course [cid=1, cname=JavaSE], Course [cid=2, cname=JavaEE]]]
	*/		
					

					
}
