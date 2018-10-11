package org.q10viking.di08;

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
		String resource = "org/q10viking/di08/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		Person p = (Person)ac.getBean("person");
		System.out.println(p);
		
		Student s = (Student) ac.getBean("student");
		System.out.println(s);
		
	}	
	/*
	Person [pname=Q10Viking, page=35]
	Student [sname=Q10Viking, sage=25]
	*/		
}
