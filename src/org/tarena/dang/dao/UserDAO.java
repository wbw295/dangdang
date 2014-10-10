package org.tarena.dang.dao;

import org.tarena.dang.entity.User;

public interface UserDAO {
	public void save(User user) throws Exception;
	
	public User findByEmail(String email) throws Exception;
	
	public void updateByUser(User user) throws Exception;

}
