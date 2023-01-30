package by.it.academy.services;

import by.it.academy.entities.Car;

import java.util.List;

public interface CarService {
    void addCar (String model, String registrationNumber, boolean status);
    List<Car> showAllCars();
}
