package com.project.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernetUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernet.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}
}
