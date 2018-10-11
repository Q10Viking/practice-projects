package org.q10viking.di09;

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
		String resource = "org/q10viking/di09/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		Student stu = (Student)ac.getBean("student");
		System.out.println(stu);
		
/*		School s = (School)ac.getBean("school");
		System.out.println(s);
		*/
	}	

	
}
