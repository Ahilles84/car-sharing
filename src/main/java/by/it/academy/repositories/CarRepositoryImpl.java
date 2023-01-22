package by.it.academy.repositories;

import by.it.academy.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {
    private final List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car("Volkswagen Polo", "AB 1234-6", false));
        cars.add(new Car ("Renault Laguna", "АТ 4578-6", false));
        cars.add(new Car ("BMW X6", "РР 5555-6", false));
    }
    @Override
    public void addCar(List<Car> cars, String model, String registrationNumber) {
        cars.add(new Car (model, registrationNumber, false));
    }

    @Override
    public List<Car> showAllCars() {
        return cars;
    }
}
