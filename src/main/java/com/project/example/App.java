package com.project.example;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {
	public static void main(String[] args) {

		//checkSessionFactory();
		insertRecord();
	}

	private static void insertRecord() {
		SessionFactory sessionfactory = HibernetUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = null;
		if (session != null) {
			try {
				Employee e1 = new Employee("Raavi", 1500000.00);
				session.save(e1);

				transaction = session.beginTransaction();
				transaction.commit();
			}
			catch (Exception e) {
				System.out.println("exception occured");
				transaction.rollback();
			}
		}
	}

	private static void checkSessionFactory() {
		SessionFactory sessionfactory = HibernetUtil.getSessionFactory();
		if (sessionfactory != null) {
			System.out.println("Session Factory object has been created");
		} else {
			System.out.println("Session Factory object has not been created");
		}

	}
}
