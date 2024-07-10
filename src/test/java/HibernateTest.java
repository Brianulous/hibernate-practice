import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HibernateTest {
    private SessionFactory sessionFactory;
    private Session session;

    @BeforeEach
    public void setUp() {
        System.out.println("Current classpath:");
        System.out.println(System.getProperty("java.class.path"));

        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void testHibernateConfiguration() {
        session.beginTransaction();
        // Perform database operations here
        session.getTransaction().commit();
    }

    @AfterEach
    public void tearDown() {
        if (session != null) {
            session.close();
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
