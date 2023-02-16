package by.it.academy.constants;

public enum SQLUser {
    GET("SELECT * FROM users WHERE login = (?)"),
    GET_ALL("SELECT * FROM users"),
    INSERT("INSERT INTO users (user_id, firstname, lastname, age, login, pass, usertype) VALUES (DEFAULT, (?), (?), (?), (?), (?), DEFAULT) RETURNING user_id"),
    DELETE("DELETE FROM users WHERE login = (?) RETURNING user_id"),
    UPDATE("UPDATE users SET pass = (?) WHERE user_id = (?) RETURNING user_id");

    public final String QUERY;

    SQLUser(String QUERY) {
        this.QUERY = QUERY;
    }
}