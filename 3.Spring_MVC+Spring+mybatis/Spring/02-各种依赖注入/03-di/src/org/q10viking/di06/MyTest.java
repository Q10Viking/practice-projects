package org.q10viking.di06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {	
	
	@Test
	public void test01() {
		String resource = "org/q10viking/di06/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		Student stu = (Student)ac.getBean("student");
		System.out.println(stu);
	}	
	/*
	调用setName
	调用setAge
	调用setSchool
	Student [name=Q10Viking, age=23, school=School [name=CAU]]
	*/
	
}
