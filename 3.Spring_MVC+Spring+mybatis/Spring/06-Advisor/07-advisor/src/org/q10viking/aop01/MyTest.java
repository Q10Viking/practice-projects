package org.q10viking.aop01;

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
		String resource = "org/q10viking/aop01/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		IUserService service = (IUserService) ac.getBean("studentServiceProxy");
		service.doFirst();
		System.out.println("===============");
		service.doSecond();
		System.out.println("===============");
		service.doThird();
		
	}
	/*
	执行前置增强
	doFirst method
	===============
	doSecond method
	===============
	执行前置增强
	doThird method
	*/

}
