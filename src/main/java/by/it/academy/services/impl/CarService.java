package by.it.academy.services.impl;

import by.it.academy.entities.Car;

import java.util.List;

public interface CarService {
    void addCar (List<Car> cars, String model, String registrationNumber);
    List<Car> showAllCars();
}
