package org.q10viking.test;

import org.junit.Test;
import org.q10viking.service.ISomeService;
import org.q10viking.service.SomeServiceImp;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MyTest {	
	@Test
	public void test01() {
		ISomeService service = new SomeServiceImp();
		service.doSome();
	}
	
	@Test
	public void test02() {
		//创建容器对象，加载配置文件
		//会从类路径下加载，找配置文件即根目录是src
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从容器中获取一个对象
		ISomeService service = (ISomeService) ac.getBean("myService");
		service.doSome();
	}	
	
/*	@Test
	public void test03() {
		//创建容器对象，加载配置文件
		//会从项目的根目录下查找配置文件，即项目名是根目录
		ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml");
		//从容器中获取一个对象
		ISomeService service = (ISomeService) ac.getBean("myService");
		service.doSome();
	}	
	
	@Test
	public void test04() {
		//创建容器对象，加载配置文件
		//从本地电脑的C:\applicationContext.xml加载
		ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\applicationContext.xml");
		//从容器中获取一个对象
		ISomeService service = (ISomeService) ac.getBean("myService");
		service.doSome();
	}*/	
	
	@Test
	public void test05() {
		
		BeanFactory ac = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//从容器中获取一个对象
		ISomeService service = (ISomeService) ac.getBean("myService");
		service.doSome();
		
		ISomeService service2 = (ISomeService) ac.getBean("myService");
		service2.doSome();
	}	
	
	
}
