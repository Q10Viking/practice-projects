package org.q10viking.aop01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.q10viking.utils.MyLog;
import org.q10viking.utils.MyTransactionProcessor;

public class MyInvocationHandler implements InvocationHandler {
	private Object target;
	
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MyTransactionProcessor.doTransaction();
		Object result = method.invoke(target, args);
		MyLog.doLog();
		return result;
	}

}
