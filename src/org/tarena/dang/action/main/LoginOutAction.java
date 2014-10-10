package org.tarena.dang.action.main;

import org.tarena.dang.action.BaseAction;

public class LoginOutAction extends BaseAction {
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		session.remove("user");
		return super.execute();
	}

}
