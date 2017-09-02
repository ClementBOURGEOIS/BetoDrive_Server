package betodrive.entitiesbd;

import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			String basePath = new File("").getAbsolutePath();
			System.out.println(basePath);

			String path = new File("C:\\Users\\Clément\\Documents\\BetoDrive_Server\\src\\main\\resources\\hibernate.cgf.xml")
					.getAbsolutePath();
			System.out.println(path);
			return new AnnotationConfiguration().configure(new File(path)).buildSessionFactory();

		} catch (HibernateException ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
