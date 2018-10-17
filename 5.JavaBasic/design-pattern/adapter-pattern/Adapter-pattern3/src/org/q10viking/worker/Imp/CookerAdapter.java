package org.q10viking.worker.Imp;

import org.q10viking.worker.ICooker;
import org.q10viking.worker.IWorkAdapter;

public class CookerAdapter implements IWorkAdapter {

	@Override
	public void work(Object worker) {
		System.out.println(((ICooker)worker).cook());
	}

	@Override
	public boolean supports(Object worker) {
		return (worker instanceof ICooker);
	}
	
}
