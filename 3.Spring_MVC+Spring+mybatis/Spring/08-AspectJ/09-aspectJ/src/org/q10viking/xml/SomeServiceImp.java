package org.q10viking.xml;

public class SomeServiceImp implements ISomeService {

	@Override
	public void doFirst() {
		System.out.println("执行doFirst方法");		
	}

	@Override
	public String doSecond() {
		System.out.println("执行doSecond方法");	
		return "Hello Q10Viking";
	}

	@Override
	public void doThird() {
		System.out.println("执行doThird方法" + (3/0));	
		System.out.println("执行doThird方法");
	}

}
