package org.tarena.dang.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtil {
	public static void sendEmail(String addr,String code){
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.sina.cn");
		email.setAuthentication("administrator", "11111111");
		email.setCharset("UTF-8");
		try {
			email.addTo(addr);
			email.setFrom("administrator@sina.cn");//必须和Authentication使用的用户相同，否则失败
			email.setSubject("邮箱验证");
			StringBuffer sb = new StringBuffer();
			sb.append("欢迎注册当当网，您已完成第一步注册。");
			sb.append("下面需要进行邮箱验证，验证码为:");
			sb.append(code);
			email.setMsg(sb.toString());
			email.send();
		} catch (EmailException e) {
//			e.printStackTrace();
			System.out.println("邮件发送失败");
		}
	}
}