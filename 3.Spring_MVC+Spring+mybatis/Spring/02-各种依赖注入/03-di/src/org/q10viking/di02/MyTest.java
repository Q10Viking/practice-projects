package org.q10viking.di02;

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
		String resource = "org/q10viking/di02/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		Student stu = (Student)ac.getBean("student");
		System.out.println(stu);
	}	
	/*
	执行School构造器
	执行Student构造器
	Student [name=Q10Viking, age=23, school=School [name=CAU]]
	*/
	
}
