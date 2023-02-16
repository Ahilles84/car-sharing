package by.it.academy.constants;

public enum SQLCar {
    GET("SELECT * FROM cars WHERE car_id = (?)"),
    GET_ALL("SELECT * FROM cars"),
    INSERT("INSERT INTO cars (car_id, model, regnumber, status) VALUES (DEFAULT, (?), (?), DEFAULT) RETURNING car_id"),
    DELETE("DELETE FROM cars WHERE car_id = (?) AND regnumber = (?) RETURNING car_id"),
    UPDATE("UPDATE cars SET status = (?) WHERE car_id = (?) RETURNING car_id");

    public final String QUERY;

    SQLCar(String QUERY) {
        this.QUERY = QUERY;
    }
}
