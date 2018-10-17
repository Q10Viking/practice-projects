package org.q10viking.main;

import org.q10viking.worker.*;
import org.q10viking.worker.Imp.*;

public class Main {

	public static void main(String[] args) {
		ICooker cooker = new QjdCooker();
		IProgrammer programmer = new JdProgrammer();
		
		Object[] workers = {cooker,programmer};
		
		
		for(Object worker: workers) {
			IWorkAdapter adapter = getAdapter(worker);
			adapter.work(worker);
		}
	}
	
	
	//根据工种对象获取支持该工种的适配器对象
	private static IWorkAdapter getAdapter(Object worker) {
		IWorkAdapter cookerAdapter = new CookerAdapter();
		IWorkAdapter programmerAdapter = new ProgrammerAdapter();
		//获取到所有的适配器
		IWorkAdapter[] allAdapters = {cookerAdapter,programmerAdapter};
		//遍历每一个适配器，尝试哪一个适配器支持当前参数工种对象worker
		for(IWorkAdapter adapter: allAdapters) {
			if(adapter.supports(worker)) {
				return adapter;
			}
		}
		
		return null;
	}
}
/*
Delicious duck
Happy coding
*/

