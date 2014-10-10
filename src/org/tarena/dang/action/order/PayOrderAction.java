package org.tarena.dang.action.order;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.OrderDAO;
import org.tarena.dang.util.Factory;

public class PayOrderAction extends BaseAction {
	//input
	private int orderId;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		OrderDAO dao=(OrderDAO) Factory.getInstance("OrderDAO");
		dao.updateById(orderId);
		return super.execute();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	

}
