package org.tarena.dang.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.Book;
import org.tarena.dang.entity.Product;
import org.tarena.dang.util.DBUtil;

public class JDBCProductDAO implements ProductDAO {
	private static final String findNewProduct = "select * from d_product "
			+ "where has_deleted=0 " + "order by add_time desc limit 0, ?";
	private static final String findBooksByCatId = "select dp.*,db.*  "
			+ "from d_category_product dcp   "
			+ "      join d_product dp on(dcp.product_id = dp.id)  "
			+ "      join d_book db on(dp.id=db.id)  " + "where dcp.cat_id=? "
			+ "limit ?,?";
	private static final String findById = "select * from d_product where id=?";
	
	private static final String findAllBooks="select dp.*,db.*  "
		+ "from d_category_product dcp   "
		+ "      join d_product dp on(dcp.product_id = dp.id)  "
		+ "      join d_book db on(dp.id=db.id)  " ;

	@Override
	public List<Product> findNewProduct(int size) throws Exception {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findNewProduct);
		stat.setInt(1, size);
		ResultSet rs = stat.executeQuery();

		while (rs.next()) {
			Product pro = new Product();
			pro.setId(rs.getInt("id"));
			pro.setProductName(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAddTime(rs.getLong("add_time"));
			pro.setFixedPrice(rs.getDouble("fixed_price"));
			pro.setDangPrice(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setDeleted(rs.getInt("has_deleted"));
			pro.setProductPic(rs.getString("product_pic"));
			list.add(pro);
		}
		DBUtil.close();
		return list;
	}

	@Override
	public List<Book> findBooksByCatId(int cid, int page, int pageSize)
			throws Exception {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(findBooksByCatId);
		pst.setInt(1, cid);
		int begin = (page - 1) * pageSize;
		pst.setInt(2, begin);
		pst.setInt(3, pageSize);
		ResultSet rs = pst.executeQuery();
		List<Book> list = new ArrayList<Book>();
		while (rs.next()) {
			Book pro = new Book();
			// 设置product表字段
			pro.setId(rs.getInt("id"));
			pro.setProductName(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAddTime(rs.getLong("add_time"));
			pro.setFixedPrice(rs.getDouble("fixed_price"));
			pro.setDangPrice(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setDeleted(rs.getInt("has_deleted"));
			pro.setProductPic(rs.getString("product_pic"));
			// 设置book表字段
			pro.setAuthor(rs.getString("author"));
			pro.setPublishing(rs.getString("publishing"));
			pro.setPublishTime(rs.getLong("publish_time"));
			list.add(pro);
		}
		DBUtil.close();
		return list;
	}

	@Override
	public Product findById(int pid) throws Exception {
		// TODO Auto-generated method stub
		Product p = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findById);
		stat.setInt(1, pid);
		ResultSet rs = stat.executeQuery();
		if (rs.next()) {
			p = new Product();
			p.setId(rs.getInt("id"));
			p.setProductName(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setAddTime(rs.getLong("add_time"));
			p.setFixedPrice(rs.getDouble("fixed_price"));
			p.setDangPrice(rs.getDouble("dang_price"));
			p.setKeywords(rs.getString("keywords"));
			p.setDeleted(rs.getInt("has_deleted"));
			p.setProductPic(rs.getString("product_pic"));
		}
		DBUtil.close();
		return p;
	}

	@Override
	public List<Book> findAllBooks() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(findAllBooks);
		ResultSet rs = pst.executeQuery();
		List<Book> list = new ArrayList<Book>();
		while (rs.next()) {
			Book pro = new Book();
			// 设置product表字段
			pro.setId(rs.getInt("id"));
			pro.setProductName(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAddTime(rs.getLong("add_time"));
			pro.setFixedPrice(rs.getDouble("fixed_price"));
			pro.setDangPrice(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setDeleted(rs.getInt("has_deleted"));
			pro.setProductPic(rs.getString("product_pic"));
			// 设置book表字段
			pro.setAuthor(rs.getString("author"));
			pro.setPublishing(rs.getString("publishing"));
			pro.setPublishTime(rs.getLong("publish_time"));
			list.add(pro);
		}
		DBUtil.close();
		return list;
	}

}
