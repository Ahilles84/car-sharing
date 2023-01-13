package by.it.academy.services;

import by.it.academy.entities.User;
import by.it.academy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User createUser(String firstName, String secondName, int age) {
        return new User(firstName, secondName, age);
    }

    @Override
    public List<User> readUsers() {
        return userRepository.readUsers();
    }
}
