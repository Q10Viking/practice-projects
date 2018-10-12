package org.q10viking.aop02;

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
		String resource = "org/q10viking/aop02/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		IUserService service1 = (IUserService) ac.getBean("service1");
		service1.doFirst();
		System.out.println("===============");
		service1.doSecond();
		System.out.println("===============");
		service1.doThird();
		
		System.out.println("--------------------------");
		
		IUserService service2 = (IUserService) ac.getBean("service2");
		service2.doFirst();
		System.out.println("===============");
		service2.doSecond();
		System.out.println("===============");
		service2.doThird();
		
	}
	/*
	执行前置增强
	doFirst method
	===============
	doSecond method
	===============
	执行前置增强
	doThird method
	--------------------------
	doFirst method
	===============
	doSecond method
	===============
	doThird method
	*/

}
