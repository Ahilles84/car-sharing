package by.it.academy.dao;

import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public interface DAO<Entity, Key> {
    EntityManager entityManager = JPAUtil.getEntityManager();;
    EntityTransaction transaction = entityManager.getTransaction();;
    void create(Entity model);

    Entity read(Key key);

    void update(Entity model);

    void delete(Entity model);
    List<Entity> readAll();
}
