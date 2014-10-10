package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.Factory;

public class CheckEmailAction extends BaseAction {
	//input 
	private String code;
	private String codeMsg;
	public String getCodeMsg() {
		return codeMsg;
	}

	public void setCodeMsg(String codeMsg) {
		this.codeMsg = codeMsg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String execute() throws Exception {
		codeMsg="验证码错误";
		User user=(User)session.get("user");
		String emailVerifyCode = user.getEmailVerifyCode();
		System.out.println(emailVerifyCode);
		if(emailVerifyCode.equals(code)){
			System.out.println("right!");
			codeMsg="";
			user.setEmailVerify(Constant.YES);
			UserDAO userDao=(UserDAO) Factory.getInstance("UserDAO");
			userDao.updateByUser(user);
			return "success";
		}
		request.setAttribute("codeMsg",codeMsg);
		return "fail";
	}

}
