package by.it.academy.services;

import by.it.academy.entities.Car;
import by.it.academy.repositories.impl.CarRepository;
import by.it.academy.services.impl.CarService;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    @Override
    public void addCar(List<Car> cars, String model, String registrationNumber) {
        cars.add(new Car (model, registrationNumber, false));
    }

    @Override
    public List<Car> showAllCars() {
        return carRepository.showAllCars();
    }
}
