package by.it.academy.repositories;

import by.it.academy.entities.User;
import by.it.academy.entities.UserType;

import java.util.List;

public interface UserRepository {
    User createUser(String firstName, String secondName, int age, String login, String password, UserType userType);
    List<User> readUsers();
}
