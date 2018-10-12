package org.q10viking.annotation;

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
		String resource = "org/q10viking/annotation/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		
		ISomeService service = (ISomeService)ac.getBean("myService");
		service.doFirst();
		System.out.println("---------------");
		service.doSecond();
		System.out.println("---------------");
		service.doThird();
	}
	/*
	执行前置通知方法
	前置增强(切入点表达式), execution(void org.q10viking.annotation.ISomeService.doFirst())
	前置增强(方法签名), void org.q10viking.annotation.ISomeService.doFirst()
	前置增强(目标对象为), org.q10viking.annotation.SomeServiceImp@4466af20
	执行doFirst方法
	---------------
	执行环绕方法之前
	执行doSecond方法
	执行环绕方法之后
	执行后置通知方法
	执行后置通知方法 result: HELLO Q10VIKING
	---------------
	最终通知执行
	最终通知执行-使用切入点
	异常通知: java.lang.ArithmeticException: / by zero
	*/
	
}