package by.it.academy.dao;

import by.it.academy.entities.User;
import by.it.academy.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO implements DAO<User, String> {
    private static volatile UserDAO instance;

    private UserDAO() {
    }

    public static UserDAO getUserDao() {
        UserDAO result = instance;
        if (result != null) {
            return result;
        }
        synchronized (UserDAO.class) {
            if (instance == null) {
                instance = new UserDAO();
            }
            return instance;
        }
    }

    @Override
    public void create(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User read(String login) {
        return  null;
    }


    @Override
    public List<User> readAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<User> query = session.createQuery("from User", User.class);
            return query.list();
        }
    }
}
