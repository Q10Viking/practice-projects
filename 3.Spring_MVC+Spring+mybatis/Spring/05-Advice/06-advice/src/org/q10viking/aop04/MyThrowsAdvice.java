package org.q10viking.aop04;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowsAdvice implements ThrowsAdvice {

	public void afterThrowing(UsernameException ex) {
		//异常通知捕获到异常后所做的处理
		System.out.println("异常通知捕获到UsernameException: "+ex.getMessage());
	}
	
	public void afterThrowing(PasswordException ex) {
		//异常通知捕获到异常后所做的处理
		System.out.println("异常通知捕获到PasswordException: "+ex.getMessage());
	}
}
