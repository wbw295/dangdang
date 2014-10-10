package org.tarena.dang.action.order;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.entity.CartItem;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;

public class OrderInfoAction extends BaseAction {

	// output
	private List<CartItem> items;
	private double totalAccount;
	private boolean cartStatus = false;
	private boolean loginStatus = false;

	public boolean isCartStatus() {
		return cartStatus;
	}

	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public void setCartStatus(boolean cartStatus) {
		this.cartStatus = cartStatus;
	}

	public double getTotalAccount() {
		return totalAccount;
	}

	public void setTotalAccount(double totalAccount) {
		this.totalAccount = totalAccount;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user = (User) session.get("user");
		if (user == null) {
			loginStatus = false;
			return "login";
		}
		loginStatus = true;
		CartService cart = CartFactory.getInstance(session, request);
		items = cart.getBuyPros();
		if (items.size() == 0) {
			cartStatus = true;
			return "main";
		}
		totalAccount = cart.cost();
		return super.execute();
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

}
