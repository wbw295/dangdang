package org.tarena.dang.action.main;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.Product;
import org.tarena.dang.util.Factory;

public class NewAction extends BaseAction {
	//input
	private int size=8;
	//output
	private List<Product> pros;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//Thread.sleep(2000);//模拟延迟
		ProductDAO proDao=(ProductDAO) Factory.getInstance(
				"ProductDAO");
		pros=proDao.findNewProduct(size);
		return super.execute();
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<Product> getPros() {
		return pros;
	}
	public void setPros(List<Product> pros) {
		this.pros = pros;
	}

}
