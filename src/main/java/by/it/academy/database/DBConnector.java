package by.it.academy.database;

import java.sql.*;

public class DBConnector {
    private static final String DB_USER = "postgres";
    private static final String PASSWORD = "per4atka";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/car_sharing";
    private DBConnector(){}
    public static Connection createConnection() throws SQLException {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return DriverManager.getConnection(DATABASE_URL, DB_USER, PASSWORD);
    }
}

