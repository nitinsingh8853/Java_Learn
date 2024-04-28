package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		
		Student st1=new Student();
		st1.setId(14134);
		st1.setName("Ankit Tiwari");
		st1.setCity("LKO");
		
		Certificate certificate1=new Certificate();
		certificate1.setCourse("Android");
		certificate1.setDuration("2 months");
		
		st1.setCerti(certificate1);
		
		Student st2=new Student();
		st2.setId(1212);
		st2.setName("Ravi Tiwari");
		st2.setCity("DELHI");
		
		Certificate certificate2=new Certificate();
		certificate2.setCourse("Hibernate");
		certificate2.setDuration("1.5 months");
		
		st2.setCerti(certificate2);
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(st1);
		session.save(st2);
		
		tx.commit();
		session.close();
		factory.close();

	}

}
