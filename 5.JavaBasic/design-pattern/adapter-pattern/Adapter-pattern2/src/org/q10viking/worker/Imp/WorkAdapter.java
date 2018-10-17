package org.q10viking.worker.Imp;

import org.q10viking.worker.ICooker;
import org.q10viking.worker.IProgrammer;
import org.q10viking.worker.IWorkAdapter;

public class WorkAdapter implements IWorkAdapter {

	@Override
	public void work(Object worker) {
		if(worker instanceof IProgrammer) {
			System.out.println(((IProgrammer)worker).program());
		}
		
		if(worker instanceof ICooker) {
			System.out.println(((ICooker)worker).cook());
		}
		
	}

}
