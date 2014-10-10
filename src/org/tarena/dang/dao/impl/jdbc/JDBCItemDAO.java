package org.tarena.dang.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.tarena.dang.dao.ItemDAO;
import org.tarena.dang.entity.Item;
import org.tarena.dang.entity.Product;
import org.tarena.dang.util.DBUtil;
import org.tarena.dang.util.Factory;

public class JDBCItemDAO implements ItemDAO {
	private static final String save = "insert into d_item("
			+ "order_id,product_id,product_name,dang_price,product_num,amount)"
			+ " values (?,?,?,?,?,?)";

	private static final String findHot = "select dp.* from"
			+ " d_product dp join"
			+ " (select product_id , sum(product_num) sum_num "
			+ " from d_item di group by product_id) dnew "
			+ " on (dp.id=dnew.product_id)"
			+ " order by dnew.sum_num desc limit 0,?";

	private static final String findByOrderId = "select * from d_item where order_id=?";

	@Override
	public void save(Item item) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(save);
		stat.setInt(1, item.getOrderId());
		stat.setInt(2, item.getProductId());
		stat.setString(3, item.getProductName());
		stat.setDouble(4, item.getDangPrice());
		stat.setInt(5, item.getProductNum());
		stat.setDouble(6, item.getAmount());
		stat.executeUpdate();
		DBUtil.close();

	}

	@Override
	public List<Product> findHot(int num) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findHot);
		stat.setInt(1, num);
		ResultSet rs = stat.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setProductName(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setAddTime(rs.getLong("add_time"));
			p.setFixedPrice(rs.getDouble("fixed_price"));
			p.setDangPrice(rs.getDouble("dang_price"));
			p.setKeywords(rs.getString("keywords"));
			p.setDeleted(rs.getInt("has_deleted"));
			p.setProductPic(rs.getString("product_pic"));
			list.add(p);
		}
		DBUtil.close();
		return list;
	}

	public static void main(String args[]) throws Exception {
		ItemDAO dao = (ItemDAO) Factory.getInstance("ItemDAO");
		List<Product> list = dao.findHot(4);
		System.out.println(dao.findHot(4));
		for (Product p : list) {
			System.out.println(p.getProductName() + "	" + p.getDangPrice());
		}
	}

	@Override
	public List<Item> findByOrderId(int orderId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findByOrderId);
		stat.setInt(1, orderId);
		ResultSet rs = stat.executeQuery();
		List<Item> list = new ArrayList<Item>();

		while (rs.next()) {
			Item item = new Item();
			item.setId(rs.getInt("id"));
			item.setOrderId(rs.getInt("order_id"));
			item.setProductId(rs.getInt("product_id"));
			item.setProductName(rs.getString("product_name"));
			item.setDangPrice(rs.getDouble("dang_price"));
			item.setAmount(rs.getDouble("amount"));
			item.setProductNum(rs.getInt("product_num"));
			list.add(item);

		}
		DBUtil.close();
		return list;
	}

}
