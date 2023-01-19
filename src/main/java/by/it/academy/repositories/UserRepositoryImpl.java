package by.it.academy.repositories;

import by.it.academy.entities.User;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final List<User> users;

    public UserRepositoryImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public User createUser(String firstName, String lastName, int age, String login, String password) {
        User user = new User(firstName, lastName, age, login, password);
        users.add(user);
        return user;
    }

    @Override
    public List<User> readUsers() {
        return users;
    }
}
