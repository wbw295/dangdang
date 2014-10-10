package org.tarena.dang.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.CookieUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CartCookieInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ac
				.get(StrutsStatics.HTTP_REQUEST);
		Map<String, Object> session = ac.getSession();

		String buyedContent = CookieUtil.findCookie(Constant.CART_BUYED,
				request);
		String notBuyedContent = CookieUtil.findCookie(Constant.CART_NOTBUYED,
				request);
		CartService cart = CartFactory.getInstance(session,request);
		cart.load(buyedContent, Constant.BUYED);
		cart.load(notBuyedContent, Constant.NOTBUYED);

		invocation.invoke();

		String buyedValue = cart.store(Constant.BUYED);
		String notBuyedValue = cart.store(Constant.NOTBUYED);
		HttpServletResponse response = (HttpServletResponse) ac
				.get(StrutsStatics.HTTP_RESPONSE);
		CookieUtil.addCookie(Constant.CART_BUYED, buyedValue, response);
		CookieUtil.addCookie(Constant.CART_NOTBUYED, notBuyedValue, response);
		return null;
	}

}
