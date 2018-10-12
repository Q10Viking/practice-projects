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
		service.doSome();
		System.out.println("===============");
		service.doOther();
	}
	/*
	执行前置增强
	执行doSome方法
	===============
	执行前置增强
	执行doOther方法
	*/

}
