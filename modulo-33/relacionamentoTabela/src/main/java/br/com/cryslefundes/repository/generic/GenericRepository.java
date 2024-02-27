package main.java.br.com.cryslefundes.repository.generic;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class GenericRepository<T, E extends Serializable> implements IGenericRepository<T, E> {

    protected abstract String getTableName();

    @Override
    public T cadastrar(T entidade) {
        EntityManager entityManager = SingletonEntityManager.getInstance();

        entityManager.getTransaction().begin();
        entityManager.persist(entidade);
        entityManager.getTransaction().commit();

        SingletonEntityManager.closeInstance();

        return entidade;
    }

    @Override
    public List<T> buscarTodos() {
        EntityManager entityManager = SingletonEntityManager.getInstance();
        String nomeTabela = getTableName();

        entityManager.getTransaction().begin();
        List<T> entidades = entityManager.createQuery("SELECT e FROM " + nomeTabela + " e").getResultList();
        entityManager.getTransaction().commit();

        SingletonEntityManager.closeInstance();
        return entidades;
    }

    @Override
    public void excluir(T entidade) {
        EntityManager entityManager = SingletonEntityManager.getInstance();

        entityManager.getTransaction().begin();
        entidade = entityManager.merge(entidade);
        entityManager.remove(entidade);
        entityManager.getTransaction().commit();

        SingletonEntityManager.closeInstance();
    }
}
