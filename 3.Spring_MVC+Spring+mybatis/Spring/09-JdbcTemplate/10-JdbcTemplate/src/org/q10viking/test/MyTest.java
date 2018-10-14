package org.q10viking.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.q10viking.beans.Student;
import org.q10viking.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	
	private IStudentService service;

	@Before
	public void before() {
		String resource="applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		service = (IStudentService)ac.getBean("studentService");
		
	}
	
	//添加学生
	@Test
	public void test01() {
		Student student = new Student("Q10Viking",21);
		service.addStudent(student);
	}
	
	
	
	//根据id删除学生
	@Test
	public void test02() {
		service.removeById(38);
	}
	
	
	
	//更新学生信息
	@Test
	public void test03() {
		Student student = new Student("张更三",23);
		student.setId(1);
		service.modifyStudent(student);
	}
	
	
	
	//简单对象查询,查询所有名称
	@Test
	public void test04() {
		List<String> list = service.findAllStudentsNames();
		System.out.println(list);
	}
	
	
	
	//简单对象查询,根据id查询名字
	@Test
	public void test05() {
		String name = service.findStudentNameById(40);
		System.out.println(name);
	}
	
	
	
	//查询所有的学生
	@Test
	public void test06() {
		List<Student> students = service.findAllStudents();
		for(Student stu: students)
			System.out.println(stu);
	}
	
	
	
	//根据id查询学生
	@Test
	public void test07() {
		Student student = service.findStudentById(2);
		System.out.println(student);
	}
	
	
}
