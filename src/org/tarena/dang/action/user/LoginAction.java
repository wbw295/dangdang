package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.EncryptUtil;
import org.tarena.dang.util.Factory;

public class LoginAction extends BaseAction {
	//input
	private String name;
	private String password;
	private String loginMsg;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(name==null&&password==null){
			return "login";
		}
		loginMsg="用户名或密码错误";
		UserDAO userDao=(UserDAO) Factory.getInstance("UserDAO");
		User user=userDao.findByEmail(name);
		if(user==null){
			request.setAttribute("loginMsg", loginMsg);
			return "fail";
		}
		if(user.getPassword().equals(EncryptUtil.md5Encrypt(password))){
			loginMsg="";
			user.setLastLoginTime(System.currentTimeMillis());
			user.setLastLoginIP(request.getRemoteAddr());
			userDao.updateByUser(user);
			session.put("user", user);
			if(user.getEmailVerify().equals(Constant.NO)){
				return "verify";
			}
			return "success";
		}
		request.setAttribute("loginMsg", loginMsg);
		return "fail";
	}

}
