package org.tarena.dang.action.cart;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.entity.CartItem;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.CookieUtil;

public class CartAction extends BaseAction {
	// output
	private boolean empty = false;
	private List<CartItem> items;
	private List<CartItem> deletedItems;
	private double totalCost;
	private double totalSale;

	private void before() throws Exception {
		String buyedContent = CookieUtil.findCookie(Constant.CART_BUYED,
				request);
		String notBuyedContent = CookieUtil.findCookie(Constant.CART_NOTBUYED,
				request);
		CartService cart = CartFactory.getInstance(session, request);
		cart.load(buyedContent, Constant.BUYED);
		cart.load(notBuyedContent, Constant.NOTBUYED);
	}

	private void after() throws Exception {
		CartService cart = CartFactory.getInstance(session, request);
		String buyedValue = cart.store(Constant.BUYED);
		String notBuyedValue = cart.store(Constant.NOTBUYED);
		CookieUtil.addCookie(Constant.CART_BUYED, buyedValue, response);
		CookieUtil.addCookie(Constant.CART_NOTBUYED, notBuyedValue, response);
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// before();
		CartService cart = CartFactory.getInstance(session, request);
		totalCost = cart.cost();
		totalSale = cart.sale();
		int size = cart.getCartSize();
		if (size == 0) {
			empty = true;
			CartFactory.addCookie(response, cart);
			return "success";
		}
		items = cart.getBuyPros();
		deletedItems = cart.getDelPros();
		// after();
		CartFactory.addCookie(response, cart);
		return super.execute();
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}



	public List<CartItem> getDeletedItems() {
		return deletedItems;
	}

	public void setDeletedItems(List<CartItem> deletedItems) {
		this.deletedItems = deletedItems;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

}
