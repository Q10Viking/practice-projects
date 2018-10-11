package org.q10viking.di10;

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
		String resource = "org/q10viking/di10/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		Student stu1 = (Student)ac.getBean("student1");
		System.out.println(stu1);
		
		Student stu2 = (Student)ac.getBean("student2");
		System.out.println(stu2);
		
/*		Student base = (Student)ac.getBean("baseStudent");
		System.out.println(base);*/
	}	
	/*
	Student [name=Q10Viking, age=23, school=CAU, department=CIEE]
	Student [name=Jack, age=22, school=CAU, department=CIEE]
	*/
	
}
