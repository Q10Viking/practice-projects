package org.q10viking.aop05;

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
		String resource = "org/q10viking/aop05/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		UserService service = (UserService) ac.getBean("studentServiceProxy");
		service.doSome();
		System.out.println("===============");
		service.doOther();
	}	
	/*
	执行doSome方法
	执行后置通知: 
	===============
	执行doOther方法
	执行后置通知: Q10VIKING
	*/
}
