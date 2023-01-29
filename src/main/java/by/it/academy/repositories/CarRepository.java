package by.it.academy.repositories;

import by.it.academy.entities.Car;

import java.util.List;

public interface CarRepository {
    void addCar (String model, String registrationNumber, boolean status);
    List<Car> showAllCars();
}
