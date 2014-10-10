package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Book;
import org.tarena.dang.entity.Product;

public interface ProductDAO {
	public List<Book> findAllBooks() throws Exception;
	
	public Product findById(int pid) throws Exception;
	/**
	 * 获取最新上架图书
	 * 
	 * @param size
	 *            取多少个
	 * @return 最新上架图书集合
	 * @throws Exception
	 */
	public List<Product> findNewProduct(int size) throws Exception;

	/**
	 * 根据类别ID查询所包含的图书信息
	 * 
	 * @param cid
	 *            类别ID
	 * @return 所包含的图书信息
	 * @throws Exception
	 */
	public List<Book> findBooksByCatId(int cid, int page, int pageSize)
			throws Exception;

}
