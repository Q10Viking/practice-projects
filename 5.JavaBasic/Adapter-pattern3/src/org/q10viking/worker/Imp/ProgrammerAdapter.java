package org.q10viking.worker.Imp;

import org.q10viking.worker.IProgrammer;
import org.q10viking.worker.IWorkAdapter;

public class ProgrammerAdapter implements IWorkAdapter {

	@Override
	public void work(Object worker) {
		System.out.println(((IProgrammer)worker).program());
	}

	@Override
	public boolean supports(Object worker) {
		return (worker instanceof IProgrammer);
	}

}
