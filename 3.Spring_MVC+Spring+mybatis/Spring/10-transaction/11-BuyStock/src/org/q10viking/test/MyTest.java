package org.q10viking.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.q10viking.service.BuyStockException;
import org.q10viking.service.IBuyStockService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	
	private IBuyStockService service;

	@Before
	public void before() {
		String resource="applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		service = (IBuyStockService)ac.getBean("serviceProxy");
		
	}
/*	
	//添加用户与股票账户
	@Test
	public void test01() {
		service.openAccount("Q10Viking", 30000);
		//初始化股票账户为0股
		service.openStock("Drinking-Water", 0);
	}*/
	
	
	//进行购买股票
	@Test
	public void test02() throws BuyStockException{
		service.buyStock("Q10Viking", 2000, "Drinking-Water", 5);
	}
 
}
