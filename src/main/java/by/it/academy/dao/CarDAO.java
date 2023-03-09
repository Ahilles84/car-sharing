package by.it.academy.dao;

import by.it.academy.entities.Car;
import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CarDAO implements DAO<Car, Integer> {
    private static volatile CarDAO instance;
    private EntityManager entityManager;
    private EntityTransaction transaction;

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
        entityManager = new JPAUtil().getEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        car.setStatus(false);
        entityManager.persist(car);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public Car read(Integer id) {
        entityManager = new JPAUtil().getEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        Car car = entityManager.find(Car.class, id);
        transaction.commit();
        entityManager.close();
        return car;
    }

    @Override
    public void update(Car car) {
        entityManager = new JPAUtil().getEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        car.setStatus(true);
        entityManager.persist(car);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void delete(Car car) {
        entityManager = new JPAUtil().getEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(car);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<Car> readAll() {
        entityManager = new JPAUtil().getEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        List<Car> cars = entityManager.createQuery("from Car", Car.class).getResultList();
        transaction.commit();
        entityManager.close();
        return cars;
    }
}
