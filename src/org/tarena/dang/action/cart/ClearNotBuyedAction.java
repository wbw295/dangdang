package org.tarena.dang.action.cart;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;

public class ClearNotBuyedAction extends BaseAction {
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CartService cart = CartFactory.getInstance(session, request);
		cart.clearNotBuyed();
		CartFactory.addCookie(response, cart);
		return super.execute();
	}

}
