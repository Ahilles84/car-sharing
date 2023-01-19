package by.it.academy.services;

import by.it.academy.entities.User;
import by.it.academy.repositories.UserRepository;

import java.util.List;


public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String firstName, String lastName, int age, String login, String password) {
        return userRepository.createUser(firstName, lastName, age, login, password);
    }

    @Override
    public List<User> readUsers() {
        return userRepository.readUsers();
    }
}
