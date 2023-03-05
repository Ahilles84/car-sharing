package by.it.academy.dao;

import by.it.academy.entities.User;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserDAO implements DAO<User, String> {
    private static volatile UserDAO instance;

    private UserDAO() {
    }

    public static UserDAO getUserDao() {
        UserDAO result = instance;
        if (result != null) {
            return result;
        }
        synchronized (UserDAO.class) {
            if (instance == null) {
                instance = new UserDAO();
            }
            return instance;
        }
    }

    @Override
    public void create(User user) {
        transaction.begin();
        user.setUserType("USER");
        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }
    @Override
    public User read(String login) {
        transaction.begin();
        TypedQuery<User> query = entityManager.createQuery("from User where login = login", User.class);
        Optional<User> users = query.getResultStream().findFirst();
        User user = users.get();
        transaction.commit();
        entityManager.close();
        return user;
    }

    @Override
    public void update(User user) {
        transaction.begin();
        user.setPassword("new password");
        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void delete(User user) {
        transaction.begin();
        entityManager.remove(user);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<User> readAll() {
        transaction.begin();
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        List<User> users = query.getResultList();
        transaction.commit();
        entityManager.close();
        return users;
    }
}
