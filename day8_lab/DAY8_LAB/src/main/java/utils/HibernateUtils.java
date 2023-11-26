package utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

//Create Singleton, immutable , inherently thread-safe,time consuming sessionfactory

public class HibernateUtils {
	private static SessionFactory factory;
	
	static {
		System.out.println("in static init block");
		//empty configure object
		factory =  new Configuration().configure().buildSessionFactory();
	
	}

	public static SessionFactory getFactory() {
		return factory;
	}


	
	
}
