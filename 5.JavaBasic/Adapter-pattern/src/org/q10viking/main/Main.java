package org.q10viking.main;

import org.q10viking.worker.*;
import org.q10viking.worker.Imp.*;

public class Main {

	public static void main(String[] args) {
		ICooker cooker = new QjdCooker();
		IProgrammer programmer = new JdProgrammer();
		
		//必须逐个访问
		System.out.println(cooker.cook());
		System.out.println(programmer.program());
	}

}
/*
Delicious duck
Happy coding
*/
