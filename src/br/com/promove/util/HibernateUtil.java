package br.com.promove.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static SessionFactory sf;

	static {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	public static Session getSession() {
		return sf.openSession();
	}

}
