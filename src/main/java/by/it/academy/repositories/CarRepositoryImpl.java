package by.it.academy.repositories;

import by.it.academy.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {
    private static final List<Car> CARS = new ArrayList<>();
    private static final CarRepositoryImpl INSTANCE = new CarRepositoryImpl();

    private CarRepositoryImpl() {
    }

    public static CarRepositoryImpl getInstance() {
        return INSTANCE;
    }

    {
        CARS.add(new Car("Volkswagen Polo", "AB 1234-6", false));
        CARS.add(new Car("Renault Laguna", "АТ 4578-6", false));
        CARS.add(new Car("BMW X6", "РР 5555-6", false));
    }

    @Override
    public void addCar(String model, String registrationNumber, boolean status) {
        CARS.add(new Car(model, registrationNumber, false));
    }

    @Override
    public List<Car> showAllCars() {
        return CARS;
    }
}
