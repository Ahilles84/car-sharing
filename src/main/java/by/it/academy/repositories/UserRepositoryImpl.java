package by.it.academy.repositories;

import by.it.academy.entities.User;
import by.it.academy.entities.UserType;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static final List<User> users = new ArrayList<>();
    private static final UserRepositoryImpl USER_REPOSITORY = new UserRepositoryImpl();
    static {
        users.add(new User("Oleg", "Kuleshov", 38, "peretz", "peretz", UserType.ADMIN));
        users.add(new User("Dmitry", "Steba", 38, "dimas", "dimas", UserType.USER));
    }

    private UserRepositoryImpl() {
    }
    public static UserRepositoryImpl getUserRepository(){
        return USER_REPOSITORY;
    }

    @Override
    public User createUser(String firstName, String lastName, int age, String login, String password, UserType userType) {
        User user = new User(firstName, lastName, age, login, password, userType);
        users.add(user);
        return user;
    }

    @Override
    public List<User> readUsers() {
        return users;
    }
}
