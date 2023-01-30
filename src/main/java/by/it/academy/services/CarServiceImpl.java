package by.it.academy.services;

import by.it.academy.entities.Car;
import by.it.academy.repositories.CarRepositoryImpl;

import java.util.List;
public class CarServiceImpl implements CarService {
    private static final CarServiceImpl CAR_SERVICE = new CarServiceImpl();
    private final CarRepositoryImpl carRepository;
    private CarServiceImpl(){
        this.carRepository = CarRepositoryImpl.getCarRepository();
    }
    public static CarServiceImpl getCarService(){
        return CAR_SERVICE;
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
