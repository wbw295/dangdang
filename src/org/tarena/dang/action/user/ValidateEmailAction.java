package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.Factory;

public class ValidateEmailAction extends BaseAction {
	//input
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//output
	private boolean ok;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserDAO userDao=(UserDAO) Factory.getInstance("UserDAO");
		User user=userDao.findByEmail(email);
		if(user==null){
			ok=true;
		}
		return super.execute();
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	


}
