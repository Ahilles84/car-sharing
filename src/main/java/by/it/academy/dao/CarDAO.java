package by.it.academy.dao;

import by.it.academy.database.DBConnector;
import by.it.academy.entities.Car;
import by.it.academy.entities.User;
import by.it.academy.entities.UserType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements DAO<Car, String> {
    private static volatile CarDAO instance;

    private CarDAO() {
    }

    public static CarDAO getCarDao() {
        CarDAO result = instance;
        if (result != null) {
            return result;
        }
        synchronized (CarDAO.class) {
            if (instance == null) {
                instance = new CarDAO();
            }
            return instance;
        }
    }

    @Override
    public boolean create(Car car) {
        boolean result = false;
        try (Connection connection = DBConnector.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQLCar.INSERT.QUERY)) {
            statement.setString(1, car.getModel());
            statement.setString(2, car.getRegistrationNumber());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Car read(String registrationNumber) {
        Car car = new Car();
        car.setId(-1);
        try (Connection connection = DBConnector.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQLCar.GET.QUERY)) {
            statement.setString(1, registrationNumber);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                car.setId(resultSet.getInt(1));
                car.setModel(resultSet.getString(2));
                car.setRegistrationNumber(resultSet.getString(3));
                car.setStatus(resultSet.getBoolean(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public boolean update(Car car) {
        boolean result = false;
        try (Connection connection = DBConnector.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQLCar.UPDATE.QUERY)) {
            statement.setString(1, car.getModel());
            statement.setInt(2, car.getId());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Car car) {
        boolean result = false;
        try (Connection connection = DBConnector.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQLCar.DELETE.QUERY)) {
            statement.setInt(1, car.getId());
            statement.setString(2, car.getRegistrationNumber());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return result;
    }
    public List<Car> readAllCars() {
        final List<Car> cars = new ArrayList<>();
        try (Connection connection = DBConnector.createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQLCar.GET_ALL.QUERY);
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt(1));
                car.setModel(resultSet.getString(2));
                car.setRegistrationNumber(resultSet.getString(3));
                car.setStatus(resultSet.getBoolean(4));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    enum SQLCar {
        GET("SELECT * FROM cars WHERE regnumber = (?)"),
        GET_ALL("SELECT * FROM cars"),
        INSERT("INSERT INTO cars (car_id, model, regnumber, status) VALUES (DEFAULT, (?), (?), DEFAULT) RETURNING car_id"),
        DELETE("DELETE FROM cars WHERE car_id = (?) AND regnumber = (?) RETURNING car_id"),
        UPDATE("UPDATE cars SET model = (?) WHERE car_id = (?) RETURNING car_id");

        final String QUERY;

        SQLCar(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
