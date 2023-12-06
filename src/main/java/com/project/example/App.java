package com.project.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
	public static void main(String[] args) {

		//checkSessionFactory();
		//insertRecord();
		modifyRecord();
		//deleteRecord();
		//getAnyObject();
	}

	private static void getAnyObject() {
		Session session = HibernetUtil.getSessionFactory().openSession();
		Transaction tn = null;
		try {
			tn=session.beginTransaction();
			Employee e1 = new Employee(1,"Ravi", 2000.00);
			Employee emp = session.get(Employee.class, 4);
			System.out.println(emp);
			
		}
		catch(Exception e)
		{
			tn.rollback();
			System.out.println("Exception ocurred");
		}
		session.close();
		
	}

	private static void deleteRecord() {
		// TODO Auto-generated method stub
		
	}

	private static void modifyRecord() {
		Session session = HibernetUtil.getSessionFactory().openSession();
		Transaction tn = null;
		try {
			tn=session.beginTransaction();
			Employee employee = session.get(Employee.class, 1);
			System.out.println(employee);
			Employee e1 = new Employee(1,"Ravi", 4900.00);
//			Employee employee = session.get(Employee.class, 1);
//			System.out.println(employee);
			session.merge(e1);
			System.out.println(employee);
			tn.commit();
			
		}
		catch(Exception e)
		{
			tn.rollback();
			System.out.println("Exception ocurred");
		}
		session.close();
		
	}

	private static void insertRecord() {
		SessionFactory sessionfactory = HibernetUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = null;
		if (session != null) {
			try {
				Employee e1 = new Employee("Raavi", 1500000.00);
				Employee e2 = new Employee("chaavi", 1600000.00);
				Employee e3 = new Employee("Rahul", 00000.00);
				Employee e4 = new Employee("Rajan", 00000.00);
				
//				Serializable pk1=session.save(e1);
//				System.out.println(pk1);
//				session.save(e2);
//				session.save(e3);
//				session.save(e4);
				
//				session.persist(e1);
//				session.persist(e2);
//				session.persist(e3);
//				session.persist(e4);
				
				session.saveOrUpdate(e1);
				session.saveOrUpdate(e2);
				session.saveOrUpdate(e3);
				session.saveOrUpdate(e4);
				
				transaction = session.beginTransaction();
				transaction.commit();
			}
			catch (Exception e) {
				System.out.println("exception occured");
				transaction.rollback();
			}
		}
		session.close();
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
