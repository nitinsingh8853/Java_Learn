package com.tut;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started.." );
        
        Configuration cfg= new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        
        //Creating Student
        Student st=new Student();
        st.setId(103);
        st.setName("Kane");
        st.setCity("Mumbai");
        
        System.out.println(st);
        
        //Creating object of address class;
        Address ad=new Address();
        ad.setStreet("street2");
        ad.setCity("Mumbai");
        ad.setOpen(true);
        ad.setAddeedDate(new Date());
        ad.setX(1234.234);   
        
        Session session=factory.openSession();
        
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(ad);
        
        tx.commit();
        
        session.close();
        System.out.println("Done");
        
        
    }
}
