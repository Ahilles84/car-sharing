package by.it.academy.database;

import java.sql.*;

public class DBConnector {
    private DBConnector(){}
    public static Connection createConnection() throws SQLException {
        String DB_USER = "postgres";
        String PASSWORD = "per4atka";
        String DATABASE_URL = "jdbc:postgresql://localhost:5432/car_sharing";
        return DriverManager.getConnection(DATABASE_URL, DB_USER, PASSWORD);
    }
}

