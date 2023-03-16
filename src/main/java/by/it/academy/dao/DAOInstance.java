package by.it.academy.dao;

public enum DAOInstance {
    CAR_DAO,
    USER_DAO;
    private final UserDAO userDAO = new UserDAO();
    private final CarDAO carDAO = new CarDAO();

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public CarDAO getCarDAO() {
        return carDAO;
    }
}
