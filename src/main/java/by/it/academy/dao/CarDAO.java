package by.it.academy.dao;

import by.it.academy.entities.Car;
import by.it.academy.repositories.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDAO implements DAO<Car, String> {
    private final Connection connection;

    public CarDAO() throws SQLException {
        this.connection = DBConnector.createConnection();
    }

    @Override
    public boolean create(Car car) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(SQLCar.INSERT.QUERY)) {
            statement.setString(1, car.getModel());
            statement.setString(2, car.getRegistrationNumber());
            statement.setBoolean(3, car.isBusy());
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
        try (PreparedStatement statement = connection.prepareStatement(SQLCar.GET.QUERY)) {
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
        try (PreparedStatement statement = connection.prepareStatement(SQLCar.UPDATE.QUERY)) {
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
        try(PreparedStatement statement = connection.prepareStatement(SQLCar.DELETE.QUERY)){
            statement.setInt(1, car.getId());
            statement.setString(2, car.getRegistrationNumber());
            result = statement.executeQuery().next();
        } catch (SQLException e){
            e.getStackTrace();
        }
        return result;
    }

    enum SQLCar {
        GET("SELECT * FROM cars WHERE RegNumber = (?)"),
        INSERT("INSERT INTO cars (car_id, Model, RegNumber, Status) VALUES (DEFAULT, (?), (?), (?)) RETURNING car_id"),
        DELETE("DELETE FROM cars WHERE car_id = (?) AND RegNumber = (?) RETURNING car_id"),
        UPDATE("UPDATE cars SET Model = (?) WHERE car_id = (?) RETURNING car_id");

        final String QUERY;

        SQLCar(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}