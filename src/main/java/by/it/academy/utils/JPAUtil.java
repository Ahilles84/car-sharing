package by.it.academy.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManager ENTITY_MANAGER = buildEntityManager();
    private static EntityManager buildEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldClient");
        return emf.createEntityManager();
    }
    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER;
    }
}
