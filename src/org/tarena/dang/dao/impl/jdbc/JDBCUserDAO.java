package org.tarena.dang.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.DBUtil;
import org.tarena.dang.util.Factory;

public class JDBCUserDAO implements UserDAO {
	private static final String save = "insert into d_user("
			+ "email,nickname,password,user_integral,is_email_verify,"
			+ "email_verify_code,last_login_time,last_login_ip)"
			+ " values (?,?,?,?,?,?,?,?)";

	private static final String findByEmail = "select * from d_user where email=?";

	private static final String updateByUser = "update d_user "
			+ "set nickname=?, password=?, user_integral=?, "
			+ "is_email_verify = ?, email_verify_code=?, last_login_time=?,"
			+ " last_login_ip=?   where email=?";

	@Override
	public void save(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(save);
		stat.setString(1, user.getEmail());
		stat.setString(2, user.getNickname());
		stat.setString(3, user.getPassword());
		stat.setInt(4, user.getUserItegral());
		stat.setString(5, user.getEmailVerify());
		stat.setString(6, user.getEmailVerifyCode());
		stat.setLong(7, user.getLastLoginTime());
		stat.setString(8, user.getLastLoginIP());
		stat.executeUpdate();
		DBUtil.close();

	}

	@Override
	public User findByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		User user = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(findByEmail);
		stat.setString(1, email);
		ResultSet rs = stat.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setEmail(rs.getString("email"));
			user.setId(rs.getInt("id"));
			user.setNickname(rs.getString("nickname"));
			user.setPassword(rs.getString("password"));
			user.setUserItegral(rs.getInt("user_integral"));
			user.setEmailVerify(rs.getString("is_email_verify"));
			user.setEmailVerifyCode(rs.getString("email_verify_code"));
			user.setLastLoginTime(rs.getLong("last_login_time"));
			user.setLastLoginIP(rs.getString("last_login_ip"));
		}
		DBUtil.close();
		return user;
	}

	@Override
	public void updateByUser(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = conn.prepareStatement(updateByUser);
		stat.setString(1, user.getNickname());
		stat.setString(2, user.getPassword());
		stat.setInt(3, user.getUserItegral());
		stat.setString(4, user.getEmailVerify());
		stat.setString(5, user.getEmailVerifyCode());
		stat.setLong(6, user.getLastLoginTime());
		stat.setString(7, user.getLastLoginIP());
		stat.setString(8, user.getEmail());
		stat.executeUpdate();
		DBUtil.close();

	}

}
