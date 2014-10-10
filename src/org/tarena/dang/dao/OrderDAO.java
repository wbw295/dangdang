package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Order;

public interface OrderDAO {
	public void updateById(int orderId) throws Exception;
	
	public Order findById(int orderId) throws Exception;
	
	public void deleteById(int id) throws Exception;
	
	public List<Order> findByUserId(int userId) throws Exception;
	
	public void save(Order order) throws Exception;
	
	public Order findByOrderTime(long orderTime) throws Exception;

}
