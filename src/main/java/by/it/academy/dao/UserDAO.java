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
    private static volatile UserDAO instance;
    private EntityManager entityManager;
    private EntityTransaction transaction;

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
        entityManager = new JPAUtil().getEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        user.setRole(Role.USER);
        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public User read(String login) {
        entityManager = new JPAUtil().getEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<User> userTypedQuery = entityManager.createNamedQuery("getUserByLogin", User.class)
                .setParameter("userLogin", login);
        Optional<User> optionalUser = userTypedQuery.getResultStream().findFirst();
        User user = optionalUser.orElse(null);
        transaction.commit();
        entityManager.close();
        return user;
    }

    @Override
    public void update(User user) {
        entityManager = new JPAUtil().getEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        user.setPassword("new password");
        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void delete(User user) {
        entityManager = new JPAUtil().getEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(user);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<User> readAll() {
        entityManager = new JPAUtil().getEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        transaction.commit();
        entityManager.close();
        return users;
    }
}
