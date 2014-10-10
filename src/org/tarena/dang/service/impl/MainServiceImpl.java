package org.tarena.dang.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.tarena.dang.dao.CategoryDAO;
import org.tarena.dang.entity.Category;
import org.tarena.dang.service.MainService;
import org.tarena.dang.util.Factory;

public class MainServiceImpl implements MainService {

	@Override
	public List<Category> findLeftCategory() throws Exception {
		CategoryDAO catDao = (CategoryDAO) Factory.getInstance(
				"dao.properties", "CategoryDAO");
		List<Category> all = catDao.findAll();
//		返回parentId=1的Category对象
		List<Category> cats = findByParentId(1,all);
		//加载cats集合元素的子类别
		for(Category cat : cats){
			List<Category> subCats = 
					findByParentId(cat.getId(),all);
			cat.setSubCats(subCats);
		}
		return cats;
	}
	
	private List<Category> findByParentId(
				int pid,List<Category> all){
		List<Category> subCats = new ArrayList<Category>();
		for(Category cat : all){
			if(cat.getParentId() == pid){
				subCats.add(cat);
			}
		}
		return subCats;
	}
	public static void main(String args[]) throws Exception{
		MainService service=new MainServiceImpl();
		service.findLeftCategory();
	}
	

}
