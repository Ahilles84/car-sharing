package by.it.academy.services;

import by.it.academy.dao.CarDAO;
import by.it.academy.dao.DAOInstance;

public class CarService implements CarSharingService<CarDAO> {
    private final CarDAO carDAO;

    public CarService() {
        this.carDAO = DAOInstance.CAR_DAO.getCarDAO();
    }
    @Override
    public CarDAO getDAOInstance() {
        return this.carDAO;
    }
}
