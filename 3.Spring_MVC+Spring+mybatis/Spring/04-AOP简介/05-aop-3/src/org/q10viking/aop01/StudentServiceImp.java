package org.q10viking.aop01;

import org.q10viking.utils.MyLog;
import org.q10viking.utils.MyTransactionProcessor;

public class StudentServiceImp implements IService {

	@Override
	public void doSome() {
		System.out.println("StudentServiceImp执行doSome方法");
	}

	@Override
	public void doOther() {
		System.out.println("StudentServiceImp执行doOther方法");
	}

}
