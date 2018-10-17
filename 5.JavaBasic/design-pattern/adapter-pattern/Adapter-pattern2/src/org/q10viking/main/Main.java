package org.q10viking.main;

import org.q10viking.worker.*;
import org.q10viking.worker.Imp.*;

public class Main {

	public static void main(String[] args) {
		ICooker cooker = new QjdCooker();
		IProgrammer programmer = new JdProgrammer();
		
		Object[] workers = {cooker,programmer};
		
		IWorkAdapter adapter = new WorkAdapter();
		for(Object worker: workers) {
			adapter.work(worker);
		}
	}
}
/*
Delicious duck
Happy coding
*/

