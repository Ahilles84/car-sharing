package by.it.academy.repositories;

import java.sql.*;

/*
Main added to check connection to my DB
*/

public class DBConnector {
    public static void main(String[] args) {
        try (Connection connection = DBConnector.createConnection()){
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM users");
            while (results.next()){
                String firstName = results.getString("FirstName");
                String lastName = results.getString("LastName");
                int age = results.getInt("Age");
                String login = results.getString("Login");
                String password = results.getString("Password");
                String role = results.getString("Role");
                System.out.println(results.getRow() + ". " + firstName
                        + "\t"+ lastName
                        + "\t"+ age
                        + "\t"+ login
                        + "\t"+ password
                        + "\t"+ role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static final String DB_USER = "postgres";
    private static final String PASSWORD = "per4atka";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/car_sharing";
    private DBConnector() {}
    public static Connection createConnection() throws SQLException{
        return DriverManager.getConnection(DATABASE_URL, DB_USER, PASSWORD);
    }

}

