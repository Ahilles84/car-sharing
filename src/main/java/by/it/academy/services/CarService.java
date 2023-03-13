package by.it.academy.services;

import by.it.academy.dao.CarDAO;
import by.it.academy.dao.DAOInstance;

public class CarService implements CarSharingService {
    private final CarDAO carDAO;

    public CarService() {
        this.carDAO = DAOInstance.CAR_DAO.getCarDAO();
    }

    public CarDAO getCarDAO(){
        return this.carDAO;
    }
}
