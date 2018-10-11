package org.q10viking.di04;

public class School {
	private String name;


	public School(String name) {
		super();
		System.out.println("执行School构造器");
		this.name = name;
	}

	@Override
	public String toString() {
		return "School [name=" + name + "]";
	}
	
}
