package by.it.academy.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManager ENTITY_MANAGER = biuldEntityManager();
    private static EntityManager biuldEntityManager(){
        EntityManagerFactory carSharingClient = Persistence.createEntityManagerFactory("CarSharingClient");
        return carSharingClient.createEntityManager();
    }
    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER;
    }
}
