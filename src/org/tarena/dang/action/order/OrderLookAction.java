package org.tarena.dang.action.order;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ItemDAO;
import org.tarena.dang.dao.OrderDAO;
import org.tarena.dang.entity.Item;
import org.tarena.dang.entity.Order;
import org.tarena.dang.util.Factory;

public class OrderLookAction extends BaseAction {
	private int orderId;
	private List<Item> items;
	private double totalPrice = 0;
	private int orderStatus=0;

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ItemDAO dao = (ItemDAO) Factory.getInstance("ItemDAO");
		items = dao.findByOrderId(orderId);
		for (Item item : items) {
			totalPrice += (item.getAmount());
		}
		OrderDAO orderDao=(OrderDAO) Factory.getInstance("OrderDAO");
		Order order=orderDao.findById(orderId);
		orderStatus=order.getStatus();
		return super.execute();
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
