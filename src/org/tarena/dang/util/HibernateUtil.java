package org.tarena.dang.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Configuration conf;
	private static SessionFactory factory;
	private static ThreadLocal<Session> sessionLocal = new ThreadLocal<Session>();
	static {
		conf = new Configuration();
		conf.configure();
		factory = conf.buildSessionFactory();

	}

	public static Session getSession() {
		Session session = sessionLocal.get();
		if (session == null) {
			session = factory.openSession();
			sessionLocal.set(session);
		}
		return session;
	}

	public static void closeSession() {
		Session session = sessionLocal.get();
		sessionLocal.set(null);
		if (session != null) {
			session.close();
		}
	}

}
