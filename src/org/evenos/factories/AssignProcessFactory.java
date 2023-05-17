package org.evenos.factories;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;
import org.evenos.process.AssignProcess;

public class AssignProcessFactory implements IProcessFactory{

	@Override
	public ProcessCall newProcessInstance(String className) {
		if(className.equals("org.evenos.process.AssignProcess")) {
			return new AssignProcess();
		}
		return null;
	}

}
