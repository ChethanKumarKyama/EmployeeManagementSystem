package com.empman.serviceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class UtilityConfig {

	public static Session getSession() {
		
		Configuration configuration = new Configuration().configure("Configuaration.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		return session;
	}
}
