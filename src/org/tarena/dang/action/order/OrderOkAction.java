package org.tarena.dang.action.order;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.AddressDAO;
import org.tarena.dang.dao.ItemDAO;
import org.tarena.dang.dao.OrderDAO;
import org.tarena.dang.entity.Address;
import org.tarena.dang.entity.CartItem;
import org.tarena.dang.entity.Item;
import org.tarena.dang.entity.Order;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;
import org.tarena.dang.util.Factory;

public class OrderOkAction extends BaseAction {
	// input
	private Address address;

	// output
	private long orderTime;
	private double totalPrice;

	public String submit() throws Exception {
		CartService cart=CartFactory.getInstance(session, request);
		if(cart.getBuyPros().size()==0){
			return "main";
		}
		User user = (User) session.get("user");
		if (address.getId() == 0) {
			address.setUserId(user.getId());
			AddressDAO dao = (AddressDAO) Factory.getInstance("AddressDAO");
			dao.save(address);
		}

		Order order = new Order();
		order.setUserId(user.getId());
		order.setStatus(0);
		long orderTime = System.currentTimeMillis();
		order.setOrderTime(orderTime);
		session.put("orderTime", orderTime);
		order.setOrderDesc("");
		order.setTotalPrice(cart.cost());
		order.setReceiveName(address.getReceiveName());
		order.setFullAddress(address.getFullAddress());
		order.setPostalCode(address.getPostalCode());
		order.setMobile(address.getMobile());
		order.setPhone(address.getPhone());

		OrderDAO orderDao = (OrderDAO) Factory.getInstance("OrderDAO");
		orderDao.save(order);

		Order newOrder = orderDao.findByOrderTime(orderTime);
		int orderId = newOrder.getId();
		List<CartItem> cartItems = cart.getBuyPros();
		Item item = null;
		ItemDAO itemDao = (ItemDAO) Factory.getInstance("ItemDAO");
		for (CartItem cartItem : cartItems) {
			item = new Item();
			item.setOrderId(orderId);
			item.setProductId(cartItem.getPro().getId());
			item.setProductName(cartItem.getPro().getProductName());
			item.setDangPrice(cartItem.getPro().getDangPrice());
			item.setProductNum(cartItem.getQty());
			item.setAmount((cartItem.getPro().getDangPrice())
					* (cartItem.getQty()));
			itemDao.save(item);
		}

		cart.clear();

		return "success";
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		orderTime = (Long) session.get("orderTime");
		OrderDAO orderDao = (OrderDAO) Factory.getInstance("OrderDAO");
		Order order = orderDao.findByOrderTime(orderTime);
		totalPrice = order.getTotalPrice();
		return super.execute();
	}

	public Address getAddress() {
		return address;
	}

	public long getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
