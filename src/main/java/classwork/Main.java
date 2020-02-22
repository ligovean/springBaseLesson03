package classwork;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

            Session session = null;
        try {
//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        Book book1 = session.get(Book.class, 1);
//        session.getTransaction().commit();
//
//        System.out.println("SELECT book id = '1'" + book1);

            session = factory.getCurrentSession();
            session.beginTransaction();
            Book book3 = new Book();
            book3.setTitle("Spring in Action");
            session.save(book3);
            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }
    }
}
