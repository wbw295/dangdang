package org.tarena.dang.action.order;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.OrderDAO;
import org.tarena.dang.entity.Order;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.Factory;

public class OrderListAction extends BaseAction {
	private List<Order> orders;
	private double totalCost = 0;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user = (User) session.get("user");
		int userId = user.getId();
		OrderDAO dao = (OrderDAO) Factory.getInstance("OrderDAO");
		orders = dao.findByUserId(userId);
		for (Order order : orders) {
			totalCost += (order.getTotalPrice());
		}
		return super.execute();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
