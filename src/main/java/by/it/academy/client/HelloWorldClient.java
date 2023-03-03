package by.it.academy.client;

import by.it.academy.entities.User;
import by.it.academy.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HelloWorldClient {
    public static void main(String[] args) {
        System.out.println(getAllUsers());
    }
    private static void dirtyEntityUpdate(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        User user = session.get(User.class, 1);
        System.out.println(user);
        transaction.commit();
        session.close();
    }
    private static void removeEntity(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        User user = session.get(User.class, 20);
        session.delete(user);
        transaction.commit();
        session.close();
    }
    public static List<User> getAllUsers(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<User> query = session.createQuery("from User", User.class);
            return query.list();
        }
    }

    public static void addUser(User user ) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
