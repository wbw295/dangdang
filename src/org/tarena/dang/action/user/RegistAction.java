package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.UserService;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.EncryptUtil;
import org.tarena.dang.util.Factory;
import org.tarena.dang.util.VerifyUtil;

public class RegistAction extends BaseAction {
	// input
	private User user;

	// output
	public String submit() throws Exception {
		// 密码加密
//		System.out.println(user.getEmail());
//		System.out.println(user.getPassword());
//		System.out.println(user.getNickname());
		String password = EncryptUtil.md5Encrypt(user.getPassword());
		user.setPassword(password);
		// 设置用户初始信息
		user.setUserItegral(Constant.NORMAL);
		user.setEmailVerify(Constant.NO);
		user.setLastLoginTime(System.currentTimeMillis());
		user.setLastLoginIP(request.getRemoteAddr());
		// 生成邮箱验证码
		String code = VerifyUtil.createCode();
		user.setEmailVerifyCode(code);
		//记录
		System.out.println("用户邮箱:   "+user.getEmail());
		System.out.println("用户密码:   "+user.getPassword());
		System.out.println("邮箱验证码: "+user.getEmailVerifyCode());
		// 将user写入d_user
		UserService service=(UserService) Factory.getInstance(
				"service.properties", "UserService");
		service.regist(user);
//		System.out.println("123");
		session.put("user", user);
		return "verify";

	}
	public String form(){
		return "regist";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
