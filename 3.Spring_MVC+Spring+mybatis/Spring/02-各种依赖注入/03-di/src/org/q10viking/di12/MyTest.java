package org.q10viking.di12;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MyTest {	
	

	@Test
	public void test01() {
/*		//方法1
		String resource1 = "org/q10viking/di12/spring-base.xml";
		String resource2 = "org/q10viking/di12/spring-student.xml";
		String resource3 = "org/q10viking/di12/spring-teacher.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource1,resource2,resource3);*/
		
/*		//方法2
		String resource1 = "org/q10viking/di12/spring-base.xml";
		String resource2 = "org/q10viking/di12/spring-student.xml";
		String resource3 = "org/q10viking/di12/spring-teacher.xml";
		String[] resources= {resource1,resource2,resource3};
		ApplicationContext ac = new ClassPathXmlApplicationContext(resources);
		*/
		//方法3
		String resource = "org/q10viking/di12/spring-*.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		
		Student stu = (Student)ac.getBean("student");
		System.out.println(stu);
		
		Teacher tech = (Teacher)ac.getBean("teacher");
		System.out.println(tech);

	}	
	/*
	Student [name=Q10Viking, age=23, school=CAU, department=CIEE]
	Teacher [name=Jack, workAge=22, school=CAU, department=CIEE]
	*/
	
}
