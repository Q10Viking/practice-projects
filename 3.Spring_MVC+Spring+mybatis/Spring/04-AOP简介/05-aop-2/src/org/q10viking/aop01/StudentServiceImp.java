package org.q10viking.aop01;

import org.q10viking.utils.MyLog;
import org.q10viking.utils.MyTransactionProcessor;

public class StudentServiceImp implements IService {

	@Override
	public void doSome() {
		MyTransactionProcessor.doTransaction();
		System.out.println("StudentServiceImp执行doSome方法");
		MyLog.doLog();
	}

	@Override
	public void doOther() {
		MyTransactionProcessor.doTransaction();
		System.out.println("StudentServiceImp执行doOther方法");
		MyLog.doLog();
	}


}
