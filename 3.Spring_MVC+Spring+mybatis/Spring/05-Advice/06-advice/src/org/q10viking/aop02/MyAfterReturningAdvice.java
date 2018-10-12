package org.q10viking.aop02;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		if(returnValue !=null)
			System.out.println("执行后置通知: "+((String)returnValue).toUpperCase());
		else
			System.out.println("执行后置通知: ");
	}

}
