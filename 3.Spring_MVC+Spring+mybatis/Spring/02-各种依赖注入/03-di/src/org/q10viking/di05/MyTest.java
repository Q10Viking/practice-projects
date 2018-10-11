package org.q10viking.di05;

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
		String resource = "org/q10viking/di05/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		MyCollections mc = (MyCollections)ac.getBean("myCollections");
		System.out.println(mc);
	}	
//MyCollections [myPro={address=CHINA AGRICULTURAL UNIVERSITY, tel=17801054490}]
}
