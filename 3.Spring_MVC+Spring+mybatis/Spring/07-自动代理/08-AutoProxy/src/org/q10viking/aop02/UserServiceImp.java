package org.q10viking.aop02;

public class UserServiceImp implements IUserService {

	@Override
	public void doFirst() {
		System.out.println("doFirst method");
	}

	@Override
	public String doSecond() {
		System.out.println("doSecond method");
		return "hello Q10Viking";
	}

	@Override
	public void doThird() {
		System.out.println("doThird method");
	}


}
