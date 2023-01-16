package by.it.academy.repositories;

import by.it.academy.entities.Car;

import java.util.List;

public interface CarRepository {
    void addCar (List<Car> cars, String model, String registrationNumber);
    List<Car> showAllCars();
}
