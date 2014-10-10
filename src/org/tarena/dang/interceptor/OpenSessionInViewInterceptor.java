package org.tarena.dang.interceptor;

import org.hibernate.Transaction;
import org.tarena.dang.util.HibernateUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class OpenSessionInViewInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Transaction ts = null;
		try {
			ts = HibernateUtil.getSession().beginTransaction();
			invocation.invoke();
			ts.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (ts != null) {
				ts.rollback();
			}
		} finally {
			HibernateUtil.closeSession();
		}

		return null;
	}

}
