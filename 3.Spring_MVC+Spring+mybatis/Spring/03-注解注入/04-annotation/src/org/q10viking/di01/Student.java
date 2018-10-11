package org.q10viking.di01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("student")
public class Student {
	@Value("Q10Viking")
	private String name;
	@Value("23")
	private int age;
	@Autowired
	@Qualifier("school")
	private School school;  //域属性

	@PostConstruct
	public void initAfter() {
		System.out.println("Bean初始化完毕");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("销毁之前");
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
	}
	
	
	
	
}
