package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.Constant;

public class VerifyAction extends BaseAction {
	
	//output --- session-->user
	private String email;
	private String code;
	public String getEmail() {
		return email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user=(User) session.get("user");
		if(user.getEmailVerify().equals(Constant.YES)){
			return "main";
		}
		email=user.getEmail();
		code=user.getEmailVerifyCode();
		return super.execute();
	}

}
