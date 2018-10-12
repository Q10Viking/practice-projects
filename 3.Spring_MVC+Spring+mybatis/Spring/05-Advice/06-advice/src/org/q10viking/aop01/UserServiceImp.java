package org.q10viking.aop01;

public class UserServiceImp implements IUserService {

	@Override
	public void doSome() {
		System.out.println("执行doSome方法");		
	}

	@Override
	public String doOther() {
		System.out.println("执行doOther方法");	
		return "q10viking";
	}
}
