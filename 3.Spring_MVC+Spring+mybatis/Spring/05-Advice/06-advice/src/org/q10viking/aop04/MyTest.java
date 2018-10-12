package org.q10viking.aop04;

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
		String resource = "org/q10viking/aop04/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		IUserService service = (IUserService)ac.getBean("studentServiceProxy");
		try {
			//service.check("Q10Viking1", "Ilovecau");
			service.check("Q10Viking", "Ilovecau");
		}catch(Exception e) {
			//
		}
	}	
	/*
	异常通知捕获到UsernameException: 用户名有误
	*/
	//或
	/*
	异常通知捕获到PasswordException: 密码有误
	*/

}
