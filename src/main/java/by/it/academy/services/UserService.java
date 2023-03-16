package by.it.academy.services;

import by.it.academy.dao.DAOInstance;
import by.it.academy.dao.UserDAO;

public class UserService implements CarSharingService<UserDAO> {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = DAOInstance.USER_DAO.getUserDAO();
    }

    @Override
    public UserDAO getDAOInstance() {
        return this.userDAO;
    }
}
