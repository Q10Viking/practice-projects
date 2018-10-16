package org.q10viking.test;

import org.junit.Before;
import org.junit.Test;
import org.q10viking.beans.Student;
import org.q10viking.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
	
	private IStudentService service;

	@Before
	public void defore() {
		System.out.println("Before");
		String resource = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		service = (IStudentService)ac.getBean("studentService");
		
	}
/*	//Spring环境搭建
	@Test
	public void test01() {
		service.testSpring();
		System.out.println("Hello world");
	}
	*/
	
/*	
	//添加学生
	@Test
	public void test02() {
		Student student = new Student("Q10Viking",52);
		service.addStudent(student);
		System.out.println(student+ "添加成功");
	}
	
	*/
/*	
	//删除学生
	@Test
	public void test03() {
		service.removeStudentById(44);
		System.out.println("删除成功");
	}
	*/
/*	
	//添加学生
	@Test
	public void test04() {
		Student student = new Student("黄壮壮",23);
		student.setId(43);
		service.modifyStudent(student);
		System.out.println("更新成功");
	}
	*/
	
	//打印所有学生名称
	@Test
	public void test05() {
		System.out.println(service.findAllStudentsNames());
	}
	
/*	
	//根据id打印学生名称
	@Test
	public void test06() {
		System.out.println(service.findStudentNameById(45));
	}
	*/
	
	
	
}
