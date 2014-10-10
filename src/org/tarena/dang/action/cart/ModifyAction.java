package org.tarena.dang.action.cart;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;

public class ModifyAction extends BaseAction {
	//input
	private int pid;
	private int qty;
	private double totalCost;
	private double totalSale;
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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CartService cart=CartFactory.getInstance(session,request);
		cart.modify(pid, qty);
		totalCost=cart.cost();
		totalSale=cart.sale();
		CartFactory.addCookie(response, cart);
		return super.execute();
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

}
