package org.tarena.dang.action.main;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.entity.User;

public class MainVerifyAction extends BaseAction {
	private boolean ok=false;
	private String nickName;
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user=(User) session.get("user");
		if(user==null){
			return "success";
		}
		nickName=user.getNickname();
		ok=true;
		return super.execute();
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

}
