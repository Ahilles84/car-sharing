package by.it.academy.dao;

import by.it.academy.entities.User;
import by.it.academy.entities.UserType;
import by.it.academy.database.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User, String> {
    private static volatile UserDAO instance;

    private UserDAO() {
    }

    public static UserDAO getUserDao() {
        UserDAO result = instance;
        if (result != null) {
            return result;
        }
        synchronized (UserDAO.class) {
            if (instance == null) {
                instance = new UserDAO();
            }
            return instance;
        }
    }

    @Override
    public boolean create(User user) {
        boolean result = false;
        try (Connection connection = DBConnector.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQLUser.INSERT.QUERY)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User read(String login) {
        final User user = new User();
        user.setId(-1);
        try (Connection connection = DBConnector.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQLUser.GET.QUERY)) {
            statement.setString(1, login);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));
                user.setLogin(resultSet.getString(5));
                user.setPassword(resultSet.getString(6));
                user.setUserType(UserType.valueOf(resultSet.getString(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user.getId() == -1) {
            return null;
        } else {
            return user;
        }
    }

    @Override
    public boolean update(User user) {
        boolean result = false;
        try (Connection connection = DBConnector.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQLUser.UPDATE.QUERY)) {
            statement.setString(1, user.getPassword());
            statement.setInt(2, user.getId());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(User user) {
        boolean result = false;
        try (Connection connection = DBConnector.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQLUser.DELETE.QUERY)) {
            statement.setString(1, user.getLogin());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<User> readAllUsers() {
        final List<User> users = new ArrayList<>();
        try (Connection connection = DBConnector.createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQLUser.GET_ALL.QUERY);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));
                user.setLogin(resultSet.getString(5));
                user.setPassword(resultSet.getString(6));
                user.setUserType(UserType.valueOf(resultSet.getString(7)));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    enum SQLUser {
        GET("SELECT * FROM users WHERE login = (?)"),
        GET_ALL("SELECT * FROM users"),
        INSERT("INSERT INTO users (user_id, firstname, lastname, age, login, pass, usertype) VALUES (DEFAULT, (?), (?), (?), (?), (?), DEFAULT) RETURNING user_id"),
        DELETE("DELETE FROM users WHERE login = (?) RETURNING user_id"),
        UPDATE("UPDATE users SET pass = (?) WHERE user_id = (?) RETURNING user_id");

        final String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
