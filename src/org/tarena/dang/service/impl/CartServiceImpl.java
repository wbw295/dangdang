package org.tarena.dang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.CartItem;
import org.tarena.dang.entity.Product;
import org.tarena.dang.service.CartService;
import org.tarena.dang.util.Factory;

public class CartServiceImpl implements CartService {
	private List<CartItem> store = new ArrayList<CartItem>();

	@Override
	public boolean buy(int pid) throws Exception {
		// TODO Auto-generated method stub
		// 判断购物车是否已购买
		for (CartItem item : store) {
			if (item.getPro().getId() == pid) {
				return false;
			}
		}
		// 未购买过产品
		ProductDAO dao = (ProductDAO) Factory.getInstance("ProductDAO");
		Product p = dao.findById(pid);
		CartItem item = new CartItem();
		item.setPro(p);
		item.setQty(1);
		item.setBuy(true);
		store.add(item);
		return true;
	}

	public List<CartItem> getStore() {
		return store;
	}

	public void setStore(List<CartItem> store) {
		this.store = store;
	}

	@Override
	public double cost() throws Exception {
		// TODO Auto-generated method stub
		double totalCost = 0;
		for (CartItem item : store) {
			if (item.isBuy()) {
				Product p = item.getPro();
				totalCost += (p.getDangPrice() * item.getQty());
			}
		}
		return totalCost;
	}

	@Override
	public void delete(int pid) throws Exception {
		// TODO Auto-generated method stub
		for (CartItem item : store) {
			if (item.getPro().getId() == pid) {
				item.setBuy(false);
			}
		}

	}

	@Override
	public List<CartItem> getBuyPros() throws Exception {
		// TODO Auto-generated method stub
		List<CartItem> items = new ArrayList<CartItem>();
		for (CartItem item : store) {
			if (item.isBuy()) {
				items.add(item);
			}
		}
		return items;
	}

	@Override
	public List<CartItem> getDelPros() throws Exception {
		// TODO Auto-generated method stub
		List<CartItem> items = new ArrayList<CartItem>();
		for (CartItem item : store) {
			if (!item.isBuy()) {
				items.add(item);
			}
		}
		return items;
	}

	@Override
	public void modify(int pid, int qty) throws Exception {
		// TODO Auto-generated method stub
		for (CartItem item : store) {
			if (item.getPro().getId() == pid) {
				item.setQty(qty);
			}
		}

	}

	@Override
	public void recovery(int pid) throws Exception {
		// TODO Auto-generated method stub
		for (CartItem item : store) {
			if (item.getPro().getId() == pid) {
				item.setBuy(true);
			}
		}

	}

	@Override
	public double sale() throws Exception {
		// TODO Auto-generated method stub
		double totalSale = 0;
		for (CartItem item : store) {
			if (item.isBuy()) {
				Product p = item.getPro();
				double sale = p.getFixedPrice() - p.getDangPrice();
				totalSale += (sale * item.getQty());
			}
		}
		return totalSale;
	}

	@Override
	public int getCartSize() throws Exception {
		// TODO Auto-generated method stub
		return store.size();
	}

	@Override
	public void clear() throws Exception {
		// TODO Auto-generated method stub
		store.clear();

	}

	@Override
	public String store(boolean status) throws Exception {
		// TODO Auto-generated method stub
		List<CartItem> items = null;
		if (status) {
			items = getBuyPros();
		} else {
			items = getDelPros();
		}
		if (items.size() == 0) {
			return "0";
		}
		StringBuffer buf = new StringBuffer();

		for (CartItem item : items) {
			buf.append(item.getPro().getId() + "," + item.getQty() + ";");
		}
		buf.deleteCharAt(buf.length() - 1);
		return buf.toString();
	}

	@Override
	public void load(String content, boolean status) throws Exception {
		// TODO Auto-generated method stub
		if (content == null || content.equals("0")) {
			return;
		}
		String[] contents = content.split(";");
		ProductDAO dao = (ProductDAO) Factory.getInstance("ProductDAO");
		for (int i = 0; i < contents.length; i++) {
			String itemInfo = contents[i];
			String[] infos = itemInfo.split(",");
			int pid = Integer.parseInt(infos[0]);
			int qty = Integer.parseInt(infos[1]);
			Product p = dao.findById(pid);
			CartItem item = new CartItem();
			item.setPro(p);
			item.setQty(qty);
			item.setBuy(status);
			store.add(item);
		}

	}

	@Override
	public void clearBuyed() throws Exception {
		// TODO Auto-generated method stub
		List<CartItem> newCart = new ArrayList<CartItem>();
		for (CartItem item : store) {
			if (!(item.isBuy())) {
				newCart.add(item);
			} else {
				item.setBuy(false);
				newCart.add(item);
			}
		}
		store = newCart;
	}

	@Override
	public void clearNotBuyed() throws Exception {
		// TODO Auto-generated method stub
		List<CartItem> newCart = new ArrayList<CartItem>();
		for (CartItem item : store) {
			if (item.isBuy()) {
				newCart.add(item);
			}
		}
		store = newCart;

	}

}
