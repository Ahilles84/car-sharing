package by.it.academy.dao;

import by.it.academy.entities.Car;

import java.util.List;

import static by.it.academy.constants.Constants.entityManager;
import static by.it.academy.constants.Constants.transaction;

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
        transaction.begin();
        car.setStatus(false);
        entityManager.persist(car);
        transaction.commit();
    }

    @Override
    public Car read(Integer id) {
        transaction.begin();
        Car car = entityManager.find(Car.class, id);
        transaction.commit();
        return car;
    }

    @Override
    public void update(Car car) {
        transaction.begin();
        car.setStatus(true);
        entityManager.persist(car);
        transaction.commit();
    }

    @Override
    public void delete(Car car) {
        transaction.begin();
        entityManager.remove(car);
        transaction.commit();
    }

    @Override
    public List<Car> readAll() {
        transaction.begin();
        List<Car> cars = entityManager.createQuery("from Car", Car.class).getResultList();
        transaction.commit();
        return cars;
    }
}
