package org.tarena.dang.action.cart;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;

public class DeleteAction extends BaseAction {
	//input
	private int pid;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CartService cart=CartFactory.getInstance(session,request);
		cart.delete(pid);
		CartFactory.addCookie(response, cart);
		return super.execute();
	}
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
