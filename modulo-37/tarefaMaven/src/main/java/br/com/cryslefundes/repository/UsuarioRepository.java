package br.com.cryslefundes.repository;

import br.com.cryslefundes.core.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsuarioRepository implements IUsuarioRepository {
    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;
    @Override
    public Usuario cadastrar(Usuario usuario) {
        entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        return usuario;
    }
}
