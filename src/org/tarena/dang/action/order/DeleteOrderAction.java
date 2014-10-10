package org.tarena.dang.action.order;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.OrderDAO;
import org.tarena.dang.util.Factory;

public class DeleteOrderAction extends BaseAction {
	private int id;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		OrderDAO dao=(OrderDAO) Factory.getInstance("OrderDAO");
		dao.deleteById(id);
		return super.execute();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
