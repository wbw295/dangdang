package org.tarena.dang.service.impl;

import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.UserService;
import org.tarena.dang.util.Factory;

public class UserServiceImpl implements UserService {

	@Override
	public boolean checkEmailCode(String email, String code) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void regist(User user) throws Exception {
		// TODO Auto-generated method stub
		UserDAO userDao = (UserDAO) Factory.getInstance("UserDAO");
		userDao.save(user);
	}

}
