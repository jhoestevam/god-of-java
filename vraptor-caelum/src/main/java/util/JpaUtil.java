package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public final class JpaUtil {

    private static final String PERSISTENCE_UNIT = "postgres";

    private static ThreadLocal<EntityManager> entityManagerThreadLocal = new ThreadLocal<EntityManager>();

    private static EntityManagerFactory entityManagerFactory;

    public JpaUtil() {
    }

    public static EntityManager getEntityManager(){
        if (entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        EntityManager entityManager = entityManagerThreadLocal.get();

        if (entityManager == null || entityManager.isOpen()){
            entityManager = entityManagerFactory.createEntityManager();
            JpaUtil.entityManagerThreadLocal.set(entityManager);
        }

        return entityManager;
    }

    public static void closeEntityManager(){
        EntityManager em = entityManagerThreadLocal.get();

        if (em != null){
            EntityTransaction entityTransaction = em.getTransaction();

            if (entityTransaction.isActive()){
                entityTransaction.commit();
            }

            em.close();

            entityManagerThreadLocal.set(null);
        }
    }

    public static void closeEntityManagerFactory(){
        closeEntityManager();
        entityManagerFactory.close();
    }
}
