package org.q10viking.worker;

public interface IWorkAdapter {
	//为了兼容所有工种员工，这里参数必须为Object类型
	void work(Object worker);
}
