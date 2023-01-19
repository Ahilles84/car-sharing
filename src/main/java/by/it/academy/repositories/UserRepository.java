package by.it.academy.repositories;

import by.it.academy.entities.User;

import java.util.List;

public interface UserRepository {
    User createUser(String firstName, String secondName, int age, String login, String password);
    List<User> readUsers();
}
