package by.it.academy.repositories;

import by.it.academy.entities.User;
import by.it.academy.repositories.impl.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> users;
    {
        users = List.of(new User("Oleg", "Kuleshov", 38),
                new User("Dmitry", "Steba", 38));
    }
    @Override
    public User createUser(String firstName, String secondName, int age) {
        return new User(firstName, secondName, age);
    }

    @Override
    public List<User> readUsers() {
        return users;
    }
}
