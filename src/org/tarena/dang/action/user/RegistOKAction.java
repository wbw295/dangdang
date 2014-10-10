package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.entity.User;

public class RegistOKAction extends BaseAction {
	//output
	private String nickName;
	private String email;
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user=(User) session.get("user");
		nickName=user.getNickname();
		email=user.getEmail();
		return "registOK";
	}

}
