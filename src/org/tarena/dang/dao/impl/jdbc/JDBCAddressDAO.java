package org.tarena.dang.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.tarena.dang.dao.AddressDAO;
import org.tarena.dang.entity.Address;
import org.tarena.dang.util.DBUtil;

public class JDBCAddressDAO implements AddressDAO {
	private static final String findAll = "select * from d_receive_address";

	private static final String findByFullAddress = "select * from"
			+ " d_receive_address where full_address=?";

	private static final String save = "insert into d_receive_address("
			+ "user_id,receive_name,full_address,postal_code,mobile,phone)"
			+ " values (?,?,?,?,?,?)";

	private static final String findById = "select * from "
			+ "d_receive_address where id=?";

	private static final String findByUserId = "select * from"
			+ " d_receive_address where user_id=?";

	@Override
	public Address findByFullAddress(String fullAddress) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findByFullAddress);
		stat.setString(1, fullAddress);
		ResultSet rs = stat.executeQuery();
		Address address = null;
		if (rs.next()) {
			address = new Address();
			address.setId(rs.getInt("id"));
			address.setReceiveName("receive_name");
			address.setFullAddress(rs.getString("full_address"));
			address.setUserId(rs.getInt("user_id"));
			address.setPostalCode(rs.getString("postal_code"));
			address.setPhone(rs.getString("phone"));
			address.setMobile(rs.getString("mobile"));
		}
		DBUtil.close();

		return address;
	}

	@Override
	public List<Address> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Address> list = new ArrayList<Address>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findAll);
		ResultSet rs = stat.executeQuery();
		while (rs.next()) {
			Address address = new Address();
			address.setId(rs.getInt("id"));
			address.setReceiveName("receive_name");
			address.setFullAddress(rs.getString("full_address"));
			address.setUserId(rs.getInt("user_id"));
			address.setPostalCode(rs.getString("postal_code"));
			address.setPhone(rs.getString("phone"));
			address.setMobile(rs.getString("mobile"));
			list.add(address);
		}
		DBUtil.close();
		return list;
	}

	@Override
	public void save(Address address) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(save);
		stat.setInt(1, address.getUserId());
		stat.setString(2, address.getReceiveName());
		stat.setString(3, address.getFullAddress());
		stat.setString(4, address.getPostalCode());
		stat.setString(5, address.getMobile());
		stat.setString(6, address.getPhone());
		stat.executeUpdate();
		DBUtil.close();

	}

	@Override
	public Address findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Address address = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findById);
		stat.setInt(1, id);
		ResultSet rs = stat.executeQuery();
		if (rs.next()) {
			address = new Address();
			address.setId(rs.getInt("id"));
			address.setUserId(rs.getInt("user_id"));
			address.setReceiveName(rs.getString("receive_name"));
			address.setFullAddress(rs.getString("full_address"));
			address.setPostalCode(rs.getString("postal_code"));
			address.setMobile(rs.getString("mobile"));
			address.setPhone(rs.getString("phone"));
		}
		DBUtil.close();
		return address;
	}

	@Override
	public List<Address> findByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		List<Address> list = new ArrayList<Address>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findByUserId);
		stat.setInt(1, userId);
		ResultSet rs = stat.executeQuery();
		while (rs.next()) {
			Address address = new Address();
			address.setId(rs.getInt("id"));
			address.setUserId(rs.getInt("user_id"));
			address.setReceiveName(rs.getString("receive_name"));
			address.setFullAddress(rs.getString("full_address"));
			address.setPostalCode(rs.getString("postal_code"));
			address.setMobile(rs.getString("mobile"));
			address.setPhone(rs.getString("phone"));
			list.add(address);
		}

		return list;
	}
}
