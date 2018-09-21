package org.q10viking.test;

import org.junit.Before;
import org.junit.Test;
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
	public void testInsert() {
		Student student=new Student("Q10",23,97.5);
		System.out.println(student);
		dao.insertStu(student);
	}
}
