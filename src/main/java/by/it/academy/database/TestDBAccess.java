package by.it.academy.database;

import by.it.academy.dao.UserDAO;
import by.it.academy.entities.User;

/*
Class used for testing work with DB
*/
public class TestDBAccess {
    public static void main(String[] args) {
        UserDAO userDAO = UserDAO.getUserDao();
        String login = "peretz";
        User user = userDAO.read(login);
        System.out.println(user);
    }
}
