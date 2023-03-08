package by.it.academy.dao;

import by.it.academy.entities.Role;
import by.it.academy.entities.User;
import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserDAO implements DAO<User, String> {
    private static final EntityManager entityManager;
    private static final EntityTransaction transaction;
    private static volatile UserDAO instance;

    static {
        entityManager = JPAUtil.getEntityManager();
        transaction = entityManager.getTransaction();
    }

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
        user.setRole(Role.USER);
        entityManager.persist(user);
        transaction.commit();
    }

    @Override
    public User read(String login) {
        transaction.begin();
        TypedQuery<User> userTypedQuery = entityManager.createNamedQuery("getUserByLogin", User.class)
                .setParameter("userLogin", login);
        Optional<User> optionalUser = userTypedQuery.getResultStream().findFirst();
        User user = optionalUser.orElse(null);
        transaction.commit();
        return user;
    }

    @Override
    public void update(User user) {
        transaction.begin();
        user.setPassword("new password");
        entityManager.persist(user);
        transaction.commit();
    }

    @Override
    public void delete(User user) {
        transaction.begin();
        entityManager.remove(user);
        transaction.commit();
    }

    @Override
    public List<User> readAll() {
        transaction.begin();
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        transaction.commit();
        return users;
    }
}
