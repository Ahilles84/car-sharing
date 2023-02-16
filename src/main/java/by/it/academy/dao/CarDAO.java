package by.it.academy.dao;

import by.it.academy.constants.SQLCar;
import by.it.academy.database.DBConnector;
import by.it.academy.entities.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements DAO<Car, Integer> {
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
    public Car read(Integer id) {
        Car car = new Car();
        car.setId(-1);
        try (Connection connection = DBConnector.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQLCar.GET.QUERY)) {
            statement.setInt(1, id);
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
        if (car.getId() == -1) {
            return null;
        } else {
            return car;
        }
    }

    @Override
    public boolean update(Car car) {
        boolean result = false;
        try (Connection connection = DBConnector.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQLCar.UPDATE.QUERY)) {
            statement.setBoolean(1, true);
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

    @Override
    public List<Car> readAll() {
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
}
