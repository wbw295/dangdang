package org.tarena.dang.action.cart;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;

public class AddCartAction extends BaseAction {
	
	//input
	private int pid;
	
	//output
	private boolean buy=false;
	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		CartService cart=CartFactory.getInstance(session,request);
		buy=cart.buy(pid);
		CartFactory.addCookie(response, cart);
		return super.execute();
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public boolean isBuy() {
		return buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	
	

}
