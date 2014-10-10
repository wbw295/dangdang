package org.tarena.dang.action.main;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.entity.Category;
import org.tarena.dang.service.MainService;
import org.tarena.dang.util.Factory;

public class CategoryAction extends BaseAction {
	private List<Category> cats;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		MainService service=(MainService) Factory.getInstance(
				"service.properties", "MainService");
		cats=service.findLeftCategory();
		return super.execute();
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}

}
