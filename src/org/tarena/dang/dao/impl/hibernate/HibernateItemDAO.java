package org.tarena.dang.dao.impl.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import org.tarena.dang.dao.ItemDAO;
import org.tarena.dang.entity.Item;
import org.tarena.dang.entity.Product;
import org.tarena.dang.util.HibernateUtil;

public class HibernateItemDAO implements ItemDAO {

	@Override
	@Test
	public List<Item> findByOrderId(int orderId) throws Exception {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		String hql="from Item where order.id=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, orderId);
		List<Item> list=query.list();
		HibernateUtil.closeSession();
		return list;
	}

	@Override
	public List<Product> findHot(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Item item) throws Exception {
		// TODO Auto-generated method stub

	}
	public static void main(String args[]) throws Exception{
		ItemDAO dao=new HibernateItemDAO();
		
		List<Item> items=dao.findByOrderId(28);
		
		System.out.println(items);
	}

}
