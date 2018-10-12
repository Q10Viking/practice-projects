package org.q10viking.aop01;

public class StudentServiceImp implements IService {

	@Override
	public void doSome() {
		doTransaction();
		System.out.println("StudentServiceImp执行doSome方法");
		doLog();
	}

	@Override
	public void doOther() {
		doTransaction();
		System.out.println("StudentServiceImp执行doOther方法");
		doLog();
	}

	private void doLog() {
		System.out.println("执行日志代码");
	}
	
	private void doTransaction() {
		System.out.println("执行事务代码");
	}
}
