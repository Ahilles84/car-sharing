package by.it.academy.services;

import by.it.academy.entities.User;
import by.it.academy.entities.UserType;
import by.it.academy.repositories.UserRepository;
import by.it.academy.repositories.UserRepositoryImpl;

import java.util.List;


public class UserServiceImpl implements UserService {
    private static final UserServiceImpl USER_SERVICE = new UserServiceImpl();
    private final UserRepository userRepository;

    private UserServiceImpl() {
        this.userRepository = UserRepositoryImpl.getUserRepository();
    }
    public static UserServiceImpl getUserService(){
        return USER_SERVICE;
    }

    @Override
    public User createUser(String firstName, String lastName, int age, String login, String password, UserType userType) {
        return this.userRepository.createUser(firstName, lastName, age, login, password, userType);
    }

    @Override
    public List<User> readUsers() {
        return this.userRepository.readUsers();
    }
}
