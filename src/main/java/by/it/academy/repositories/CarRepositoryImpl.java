package by.it.academy.repositories;

import by.it.academy.entities.Car;
import by.it.academy.repositories.impl.CarRepository;

import java.util.List;

public class CarRepositoryImpl implements CarRepository {
    private final List<Car> cars;
    {
        cars = List.of(new Car("Volkswagen Polo", "AB 1234-6", false),
                new Car ("Renault Laguna", "АТ 4578-6", false),
                new Car ("BMW X6", "РР 5555-6", false));
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
