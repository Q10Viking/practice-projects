package org.q10viking.di02;


public class Student {
	private String name;
	private int age;
	private School school;  //域属性
	
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
/*	public void setName(String name) {
		System.out.println("调用setName");
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("调用setAge");
		this.age = age;
	}*/
	
	public void setSchool(School school) {
		System.out.println("调用setSchool");
		this.school = school;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
	}
	
}
