package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Item;
import org.tarena.dang.entity.Product;

public interface ItemDAO {
	public List<Item> findByOrderId(int orderId) throws Exception;

	public List<Product> findHot(int num) throws Exception;

	public void save(Item item) throws Exception;

}
