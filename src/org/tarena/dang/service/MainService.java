package org.tarena.dang.service;

import java.util.List;

import org.tarena.dang.entity.Category;

public interface MainService {
	/**
	 * 返回主页面左侧类别菜单信息
	 * @return
	 * @throws Exception
	 */
	public List<Category> findLeftCategory() throws Exception;

}
