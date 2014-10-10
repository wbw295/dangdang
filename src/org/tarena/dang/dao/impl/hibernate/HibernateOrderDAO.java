package org.tarena.dang.dao.impl.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.tarena.dang.dao.OrderDAO;
import org.tarena.dang.entity.Order;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.HibernateUtil;

public class HibernateOrderDAO implements OrderDAO {

	@Override
	public void deleteById(int id) throws Exception {
		Session session = HibernateUtil.getSession();
		Order order=new Order();
		order.setId(id);
		session.delete(order);
		HibernateUtil.closeSession();

	}

	@Override
	public Order findById(int orderId) throws Exception {
		Session session = HibernateUtil.getSession();
		Order order = (Order) session.get(Order.class, orderId);
		HibernateUtil.closeSession();
		return order;
	}

	@Override
	public Order findByOrderTime(long orderTime) throws Exception {
		Session session = HibernateUtil.getSession();
		String hql="from Order where orderTime=?";
		Query query=session.createQuery(hql);
		query.setLong(0, orderTime);
		Order order=(Order) query.uniqueResult();
		HibernateUtil.closeSession();
		return order;
	}

	@Override
	public List<Order> findByUserId(int userId) throws Exception {
		Session session = HibernateUtil.getSession();
		String hql="from Order where userId=?";
		Query query=session.createQuery(hql);
		List<Order> list=query.list();
		HibernateUtil.closeSession();
		return list;
	}

	@Override
	public void save(Order order) throws Exception {
		Session session = HibernateUtil.getSession();
		session.save(order);
		HibernateUtil.closeSession();

	}

	@Override
	public void updateById(int orderId) throws Exception {
		Session session = HibernateUtil.getSession();
		Order order=(Order) session.load(Order.class, orderId);
		order.setStatus(Constant.PAYED);
		session.update(order);
		HibernateUtil.closeSession();
		
	}

}
