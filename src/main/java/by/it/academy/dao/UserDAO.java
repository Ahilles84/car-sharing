package by.it.academy.dao;

import by.it.academy.entities.User;
import by.it.academy.entities.UserType;
import by.it.academy.database.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements DAO<User, String> {
    private static final UserDAO USER_DAO;

    static {
        try {
            USER_DAO = new UserDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final Connection connection;

    private UserDAO() throws SQLException {
        this.connection = DBConnector.createConnection();
    }

    public static UserDAO getUserDao() {
        return USER_DAO;
    }

    @Override
    public boolean create(User user) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.INSERT.QUERY)) {
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
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.GET.QUERY)) {
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
        if (user.getId() == -1){
            return null;
        } else {
            return user;
        }
    }

    @Override
    public boolean update(User user) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.UPDATE.QUERY)) {
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
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.DELETE.QUERY)) {
            statement.setString(1, user.getLogin());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    enum SQLUser {
        GET("SELECT * FROM users WHERE login = (?)"),
        INSERT("INSERT INTO users (user_id, firstname, lastname, age, login, pass, usertype) VALUES (DEFAULT, (?), (?), (?), (?), (?), DEFAULT) RETURNING user_id"),
        DELETE("DELETE FROM users WHERE login = (?) RETURNING user_id"),
        UPDATE("UPDATE users SET pass = (?) WHERE user_id = (?) RETURNING user_id");

        final String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
