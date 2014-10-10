package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Category;

public interface CategoryDAO {
	/**
	 * 返回所有类别信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAll() throws Exception;

	/**
	 * 根据父类别ID查询子类别信息
	 * 
	 * @param pid
	 *            父类别ID
	 * @return 子类别信息集合
	 * @throws Exception
	 */
	public List<Category> findByParentId(int pid) throws Exception;

}
