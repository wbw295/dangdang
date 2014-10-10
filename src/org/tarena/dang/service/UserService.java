package org.tarena.dang.service;

import org.tarena.dang.entity.User;

public interface UserService {
	public void regist(User user) throws Exception;
	
	public boolean checkEmailCode(String email,String code) throws Exception;

}
