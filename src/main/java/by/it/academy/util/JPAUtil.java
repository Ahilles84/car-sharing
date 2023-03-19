package by.it.academy.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private final EntityManager entityManager = biuldEntityManager();

    private EntityManager biuldEntityManager() {
        EntityManagerFactory carSharingClient = Persistence.createEntityManagerFactory("CarSharingClient");
        return carSharingClient.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
