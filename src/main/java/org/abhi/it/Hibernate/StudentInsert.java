package org.abhi.it.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentInsert {
	public static void main(String[] args) {
		// Activates and Starts the Hibernate Framework
		Configuration configuration = new Configuration();
		// loads and parse the config file

		SessionFactory factory = configuration.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Student student = new Student();
		student.setSno(1);
		student.setSname("abhiReddyJutur");
		student.setSemail("test@gmail.com");
		student.setSmobile("1111");

		session.save(student); // moves transient object to persistent state
		// (associated with a session cache)
		System.out.println("*********************" + session.getHibernateFlushMode());
		session.flush(); // data is moved
		// to the database

		/*
		 * Student student = session.get(Student.class, 1);
		 * session.delete(student);
		 */
		transaction.commit();

		System.out.println(session.contains(student));// True

		session.close();

	}
}
