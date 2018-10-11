package org.q10viking.di02;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //表示当前类充当spring容器
public class MyJavaConfig {
	//方法返回的对象Bean的名称（id）为school
	@Bean(name="school")
	public School initialSchool() {
		return new School("中国农业大学");
	}
	
	//采用byName方式注入
	@Bean(name="student",autowire=Autowire.BY_NAME)
	public Student initialStudent() {
		return new Student("Q10Viking",23);
	}
}
