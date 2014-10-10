package org.tarena.dang.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.tarena.dang.dao.OrderDAO;
import org.tarena.dang.entity.Order;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.DBUtil;

public class JDBCOrderDAO implements OrderDAO {
	private static final String save = "insert into d_order("
			+ "user_id,status,order_time,order_desc,total_price,"
			+ "receive_name,full_address,postal_code,mobile,phone)"
			+ " values (?,?,?,?,?,?,?,?,?,?)";

	private static final String findByOrderTime = "select * from d_order "
			+ "where order_time=?";

	private static final String findByUserId = "select * from d_order where user_id=?";

	private static final String deleteById = "delete from d_order where id=?";

	private static final String findById = "select * from d_order where id=?";

	private static final String updateById = "update d_order set status=? where id=?";

	@Override
	public void save(Order order) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(save);
		stat.setInt(1, order.getUserId());
		stat.setInt(2, order.getStatus());
		stat.setLong(3, order.getOrderTime());
		stat.setString(4, order.getOrderDesc());
		stat.setDouble(5, order.getTotalPrice());
		stat.setString(6, order.getReceiveName());
		stat.setString(7, order.getFullAddress());
		stat.setString(8, order.getPostalCode());
		stat.setString(9, order.getMobile());
		stat.setString(10, order.getPhone());
		stat.executeUpdate();
		DBUtil.close();

	}

	@Override
	public Order findByOrderTime(long orderTime) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findByOrderTime);
		stat.setLong(1, orderTime);
		ResultSet rs = stat.executeQuery();
		Order order = null;
		if (rs.next()) {
			order = new Order();
			order.setId(rs.getInt("id"));
			order.setUserId(rs.getInt("user_id"));
			order.setStatus(rs.getInt("status"));
			order.setOrderTime(rs.getLong("order_time"));
			order.setOrderDesc(rs.getString("order_desc"));
			order.setTotalPrice(rs.getDouble("total_price"));
			order.setReceiveName(rs.getString("receive_name"));
			order.setFullAddress(rs.getString("full_address"));
			order.setPostalCode(rs.getString("postal_code"));
			order.setMobile(rs.getString("mobile"));
			order.setPhone(rs.getString("phone"));

		}
		DBUtil.close();
		return order;
	}

	@Override
	public List<Order> findByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findByUserId);
		stat.setInt(1, userId);
		ResultSet rs = stat.executeQuery();
		while (rs.next()) {
			Order order = new Order();
			order.setId(rs.getInt("id"));
			order.setUserId(rs.getInt("user_id"));
			order.setStatus(rs.getInt("status"));
			order.setOrderTime(rs.getLong("order_time"));
			order.setOrderDesc(rs.getString("order_desc"));
			order.setTotalPrice(rs.getDouble("total_price"));
			order.setReceiveName(rs.getString("receive_name"));
			order.setFullAddress(rs.getString("full_address"));
			order.setPostalCode(rs.getString("postal_code"));
			order.setMobile(rs.getString("mobile"));
			order.setPhone(rs.getString("phone"));
			list.add(order);
		}
		DBUtil.close();
		return list;
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(deleteById);
		stat.setInt(1, id);
		stat.executeUpdate();
		DBUtil.close();

	}

	@Override
	public Order findById(int orderId) throws Exception {
		// TODO Auto-generated method stub
		Order order = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findById);
		stat.setInt(1, orderId);
		ResultSet rs = stat.executeQuery();
		if (rs.next()) {
			order = new Order();
			order.setId(rs.getInt("id"));
			order.setUserId(rs.getInt("user_id"));
			order.setStatus(rs.getInt("status"));
			order.setOrderTime(rs.getLong("order_time"));
			order.setOrderDesc(rs.getString("order_desc"));
			order.setTotalPrice(rs.getDouble("total_price"));
			order.setReceiveName(rs.getString("receive_name"));
			order.setFullAddress(rs.getString("full_address"));
			order.setPostalCode(rs.getString("postal_code"));
			order.setMobile(rs.getString("mobile"));
			order.setPhone(rs.getString("phone"));
		}
		DBUtil.close();
		return order;
	}

	@Override
	public void updateById(int orderId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(updateById);
		stat.setInt(1, Constant.PAYED);
		stat.setInt(2, orderId);
		stat.executeUpdate();
		DBUtil.close();
	}
}
