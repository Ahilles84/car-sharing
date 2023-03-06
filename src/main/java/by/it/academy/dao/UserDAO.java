package by.it.academy.dao;

import by.it.academy.entities.Role;
import by.it.academy.entities.User;
import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        user.setRole(Role.USER);
        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }
    @Override
    public User read(String login) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = null;
        Optional<User> optionalUser = entityManager.createNamedQuery("getUserByLogin", User.class)
                .getResultStream().findFirst();
        if (optionalUser.isPresent()) user = optionalUser.get();
        transaction.commit();
        entityManager.close();
        return user;
    }

    @Override
    public void update(User user) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        user.setPassword("new password");
        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void delete(User user) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(user);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<User> readAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        transaction.commit();
        entityManager.close();
        return users;
    }
}
