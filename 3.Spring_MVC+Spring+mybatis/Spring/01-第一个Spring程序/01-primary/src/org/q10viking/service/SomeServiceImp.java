package org.q10viking.service;

public class SomeServiceImp implements ISomeService {
	
	public SomeServiceImp() {
		System.out.println("执行无参构造器");
	}
	@Override
	public void doSome() {
		System.out.println("执行dosome方法");
	}
	
}
