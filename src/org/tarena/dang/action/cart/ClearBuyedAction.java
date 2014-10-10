package org.tarena.dang.action.cart;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;

public class ClearBuyedAction extends BaseAction {
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CartService cart=CartFactory.getInstance(session, request);
		cart.clearBuyed();
		CartFactory.addCookie(response, cart);
		return super.execute();
	}

}
