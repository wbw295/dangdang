package org.tarena.dang.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tarena.dang.util.Constant;
import org.tarena.dang.util.CookieUtil;
import org.tarena.dang.util.Factory;

public class CartFactory {
	public static CartService getInstance(Map<String, Object> session,
			HttpServletRequest request) throws Exception {
		CartService cart = (CartService) session.get(Constant.CART);
		if (cart == null) {
			cart = (CartService) Factory.getInstance("service.properties",
					"CartService");
			loadCookie(session, request, cart);
			session.put(Constant.CART, cart);
		}
		return cart;
	}

	private static void loadCookie(Map<String, Object> session,
			HttpServletRequest request, CartService cart) throws Exception {
		String buyedContent = CookieUtil.findCookie(Constant.CART_BUYED,
				request);
		String notBuyedContent = CookieUtil.findCookie(Constant.CART_NOTBUYED,
				request);
		cart.load(buyedContent, Constant.BUYED);
		cart.load(notBuyedContent, Constant.NOTBUYED);

	}

	public static void addCookie(HttpServletResponse response, CartService cart)
			throws Exception {
		String buyedValue = cart.store(Constant.BUYED);
		String notBuyedValue = cart.store(Constant.NOTBUYED);
		CookieUtil.addCookie(Constant.CART_BUYED, buyedValue, response);
		CookieUtil.addCookie(Constant.CART_NOTBUYED, notBuyedValue, response);

	}

}
