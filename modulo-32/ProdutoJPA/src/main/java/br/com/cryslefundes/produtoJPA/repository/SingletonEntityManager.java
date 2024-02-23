package main.java.br.com.cryslefundes.produtoJPA.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEntityManager {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static EntityManager getInstance() {
        if (em == null || emf == null) {
            em = init();
        } else if (!em.isOpen() && !emf.isOpen()) {
            em = init();
        }
        return em;
    }

    private static EntityManager init() {
        emf = Persistence.createEntityManagerFactory("ProdutoJPA");
        em = emf.createEntityManager();
        return em;
    }

    public static void closeInstance() {
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }
}
