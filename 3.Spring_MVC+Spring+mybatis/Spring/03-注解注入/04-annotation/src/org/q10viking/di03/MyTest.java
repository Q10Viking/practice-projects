package org.q10viking.di03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:org/q10viking/di03/applicationContext.xml")
public class MyTest {	
	@Autowired
	private Student student;
	
	@Test
	public void test01() {
		System.out.println(student);
	}	
	/*
	调用setName
	调用setAge
	调用setSchool
	Student [name=Q10Viking, age=23, school=School [name=CAU]]
	*/		
}
