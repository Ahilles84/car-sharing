package by.it.academy.dao;

import by.it.academy.entities.Car;
import by.it.academy.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CarDAO implements DAO<Car, Integer> {
    private static volatile CarDAO instance;

    private CarDAO() {
    }

    public static CarDAO getCarDao() {
        CarDAO result = instance;
        if (result != null) {
            return result;
        }
        synchronized (CarDAO.class) {
            if (instance == null) {
                instance = new CarDAO();
            }
            return instance;
        }
    }

    @Override
    public void create(Car car) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Car read(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Car car = session.get(Car.class, id);
        transaction.commit();
        session.close();
        return car;
    }


    @Override
    public List<Car> readAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Car> query = session.createQuery("from Car", Car.class);
            return query.list();
        }
    }
}
