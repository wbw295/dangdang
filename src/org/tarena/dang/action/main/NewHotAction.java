package org.tarena.dang.action.main;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ItemDAO;
import org.tarena.dang.entity.Product;
import org.tarena.dang.util.Factory;

public class NewHotAction extends BaseAction {
	private List<Product> hotProducts;
	private int num=10;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ItemDAO dao=(ItemDAO) Factory.getInstance("ItemDAO");
		hotProducts=dao.findHot(num);
		return super.execute();
	}

	public List<Product> getHotProducts() {
		return hotProducts;
	}

	public void setHotProducts(List<Product> hotProducts) {
		this.hotProducts = hotProducts;
	}
	

}
