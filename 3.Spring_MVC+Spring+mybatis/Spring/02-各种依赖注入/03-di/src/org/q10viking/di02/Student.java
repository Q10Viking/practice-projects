package org.q10viking.di02;

public class Student {
	private String name;
	private int age;
	private School school;  //域属性

	
	public Student(String name, int age, School school) {
		super();
		System.out.println("执行Student构造器");
		this.name = name;
		this.age = age;
		this.school = school;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
	}
	
}
