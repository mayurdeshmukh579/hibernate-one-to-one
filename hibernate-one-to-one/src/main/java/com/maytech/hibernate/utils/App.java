package com.maytech.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.maytech.hibernate.entity.Passport;
import com.maytech.hibernate.entity.Student;

public class App {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Passport.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		
		Passport sreePassport = new Passport();
		sreePassport.setPassportNumber("wyueh12q3ddjjdh");
		
		Student sree = new Student();
		sree.setStudentName("omi");
		sree.setStudentCountry("nz");
		sree.setPassport(sreePassport);
		
		transaction.begin();
		
		//session.save(sreePassport);
		session.save(sree);
		
		transaction.commit();
	}

}
