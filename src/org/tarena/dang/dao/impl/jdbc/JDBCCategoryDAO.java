package org.tarena.dang.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.tarena.dang.dao.CategoryDAO;
import org.tarena.dang.entity.Category;
import org.tarena.dang.util.DBUtil;

public class JDBCCategoryDAO implements CategoryDAO {
	private static final String findAll = "select * from d_category order by turn";
	private static final String findByParentId = 
		"select dc.*, "+
		"	count(dcp.product_id) as pnum "+
		"from d_category dc  "+
		"	left outer join d_category_product dcp  "+
		"	on(dc.id=dcp.cat_id) "+
		"where dc.parent_id=? "+
		"group by dc.id "+
		"order by dc.turn ";

	@Override
	public List<Category> findAll() throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		PreparedStatement stat=conn.prepareStatement(findAll);
		ResultSet rs=stat.executeQuery();
		List<Category> list=new ArrayList<Category>();
		while(rs.next()){
			Category cat=new Category();
			cat.setId(rs.getInt("id"));
			cat.setTurn(rs.getInt("turn"));
			cat.setName(rs.getString("name"));
			cat.setEnName(rs.getString("en_name"));
			cat.setDescription(rs.getString("description"));
			cat.setParentId(rs.getInt("parent_id"));
			list.add(cat);
		}
		DBUtil.close();
		return list;
	}

	@Override
	public List<Category> findByParentId(int pid) throws Exception {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(findByParentId);
		pst.setInt(1, pid);
		ResultSet rs = pst.executeQuery();
		List<Category> list = new ArrayList<Category>();
		while(rs.next()){
			Category cat = new Category();
			cat.setId(rs.getInt("id"));
			cat.setTurn(rs.getInt("turn"));
			cat.setName(rs.getString("name"));
			cat.setEnName(rs.getString("en_name"));
			cat.setDescription(rs.getString("description"));
			cat.setParentId(rs.getInt("parent_id"));
			//获取类别包含的产品数量
			cat.setPnum(rs.getInt("pnum"));
			list.add(cat);
		}
		DBUtil.close();
		return list;
	}

}
