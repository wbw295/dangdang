package org.tarena.dang.service;

import java.util.List;

import org.tarena.dang.entity.CartItem;

public interface CartService {
	public String store(boolean status) throws Exception;
	
	public void load(String content, boolean status) throws Exception;
	
	public int getCartSize() throws Exception;

	public boolean buy(int pid) throws Exception;

	public void modify(int pid, int qty) throws Exception;

	public void delete(int pid) throws Exception;

	public void recovery(int pid) throws Exception;

	/**
	 * 统计"确认购买"的商品金额
	 * 
	 * @return
	 * @throws Exception
	 */
	public double cost() throws Exception;

	/**
	 * 统计"确认购买"的商品节省金额
	 * 
	 * @return
	 * @throws Exception
	 */
	public double sale() throws Exception;

	/**
	 * 获取"确认购买"的商品显示列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CartItem> getBuyPros() throws Exception;

	/**
	 * 获取"取消购买"的商品显示列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CartItem> getDelPros() throws Exception;
	
	/**
	 * 清空购物车
	 * @throws Exception
	 */
	public void clear() throws Exception;
	
	public void clearBuyed() throws Exception;
	
	public void clearNotBuyed() throws Exception;
}
