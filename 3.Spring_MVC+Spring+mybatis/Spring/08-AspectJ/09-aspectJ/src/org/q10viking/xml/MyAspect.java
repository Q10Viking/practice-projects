package org.q10viking.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class MyAspect {
	//前置通知
	public void myBefore() {
		System.out.println("执行前置通知方法");
	}
	
	//@Before 前置通知-增强方法有 JoinPoint 参数
	public void myBeforeOther(JoinPoint jp) {
		System.out.println("前置增强(切入点表达式), "+jp);
		System.out.println("前置增强(方法签名), "+jp.getSignature());
		System.out.println("前置增强(目标对象为), "+jp.getTarget());
		
		Object[] args = jp.getArgs();
		if(args.length>0) {
			System.out.println("前置增强(方法参数): ");
			for(Object arg: args) {
				System.out.println(arg);
			}
		}
	}
	
	//后置通知
	public void myAfterReturning() {
		System.out.println("执行后置通知方法");
	}
	
	//@AfterReturning 后置通知-注解有 returning 属性
	public void myAfterReturning(Object result) {
		System.out.println("执行后置通知方法 result: "+result);
	}
	
	//@Around 环绕通知-增强方法有 ProceedingJoinPoint 参数
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("执行环绕方法之前");
		Object result = pjp.proceed();
		System.out.println("执行环绕方法之后");
		if(result != null) {
			result =((String)result).toUpperCase();
		}
		return result;
	}
	
	//@AfterThrowing 异常通知-注解中有 throwing 属性
	public void myThrowing(Throwable ex) {
		System.out.println("异常通知: "+ ex);
	}
	
	
	//@After最终通知
	public void myAfter() {
		System.out.println("最终通知执行");
	}
	
}
