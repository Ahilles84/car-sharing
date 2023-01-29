package by.it.academy.services;

import by.it.academy.entities.Car;
import by.it.academy.repositories.CarRepository;
import by.it.academy.repositories.CarRepositoryImpl;

import java.util.List;
public class CarServiceImpl implements CarService {
    private static final CarServiceImpl INSTANCE = new CarServiceImpl();
    private final CarRepositoryImpl carRepository;
    private CarServiceImpl(){
        this.carRepository = CarRepositoryImpl.getInstance();
    }
    public static CarServiceImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public void addCar(String model, String registrationNumber, boolean status) {
        carRepository.addCar(model, registrationNumber, false);
    }

    @Override
    public List<Car> showAllCars() {
        return carRepository.showAllCars();
    }
}
