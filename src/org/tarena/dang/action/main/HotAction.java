package org.tarena.dang.action.main;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ItemDAO;
import org.tarena.dang.entity.Product;
import org.tarena.dang.util.Factory;

public class HotAction extends BaseAction {
	private int num = 4;
	private List<Product> products;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ItemDAO dao = (ItemDAO) Factory.getInstance("ItemDAO");
		products = dao.findHot(num);
		return super.execute();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
