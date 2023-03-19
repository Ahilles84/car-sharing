package by.it.academy.dao;

import by.it.academy.entities.Car;
import by.it.academy.entities.User;
import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CarDAO implements DAO<Car, Integer> {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    private void initEntityManager(){
        entityManager = new JPAUtil().getEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public void create(Car car) {
        initEntityManager();
        transaction.begin();
        entityManager.persist(car);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public Car read(Integer id) {
        initEntityManager();
        transaction.begin();
        Car car = entityManager.find(Car.class, id);
        transaction.commit();
        entityManager.close();
        return car;
    }

    @Override
    public void update(Car car) {
        initEntityManager();
        transaction.begin();
        Car bookedCar = entityManager.merge(car);
        bookedCar.setStatus(true);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void delete(Car car) {
        initEntityManager();
        transaction.begin();
        Car deletedCar = entityManager.merge(car);
        entityManager.remove(deletedCar);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<Car> readAll() {
        initEntityManager();
        transaction.begin();
        List<Car> cars = entityManager.createQuery("from Car", Car.class).getResultList();
        transaction.commit();
        entityManager.close();
        return cars;
    }
    public void rentCarByUser(Car car, User user){
        initEntityManager();
        transaction.begin();
        Car bookedCar = entityManager.merge(car);
        bookedCar.setUser(user);
        bookedCar.setStatus(true);
        transaction.commit();
        entityManager.close();
    }
}
