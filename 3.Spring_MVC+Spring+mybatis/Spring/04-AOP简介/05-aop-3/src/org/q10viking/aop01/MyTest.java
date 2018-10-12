package org.q10viking.aop01;

import java.lang.reflect.Proxy;

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
		IService target = new StudentServiceImp();
		IService service = (IService)Proxy.newProxyInstance(
							target.getClass().getClassLoader(),
							target.getClass().getInterfaces(),
							new MyInvocationHandler(target));
		service.doSome();
		service.doOther();
		
	}
	/*
	执行事务代码
	StudentServiceImp执行doSome方法
	执行日志代码
	执行事务代码
	StudentServiceImp执行doOther方法
	执行日志代码
 */
}
