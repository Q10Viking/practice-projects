package org.q10viking.aop03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("执行前增强");
		//执行目标方法
		Object result = invocation.proceed();
		System.out.println("执行后增强");
		if(result != null) {
			return ((String)result).toUpperCase();
		}
		return result;
	}

}
