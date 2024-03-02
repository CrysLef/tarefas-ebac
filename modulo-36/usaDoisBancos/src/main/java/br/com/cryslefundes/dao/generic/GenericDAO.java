package main.java.br.com.cryslefundes.dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GenericDAO<T, E extends Serializable> implements IGenericDAO<T, E> {
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    private Class<T> persistenteClass;
    private static final String PERSISTENCE_UNIT_NAME = "postgres";
    private String persistenceUnitName;

    public GenericDAO(Class<T> persistenteClass, String persistenceUnitName) {
        this.persistenteClass = persistenteClass;
        this.persistenceUnitName = persistenceUnitName;
    }

    private String getPersistenceName() {
        return persistenceUnitName != null && !persistenceUnitName.isEmpty() ? persistenceUnitName : PERSISTENCE_UNIT_NAME;
    }

    protected void openConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory(getPersistenceName());
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
    }

    protected void closeConnection() {
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public T cadastrar(T entidade) {
        openConnection();
        entityManager.persist(entidade);
        closeConnection();
        return entidade;
    }

    @Override
    public void excluir(T entidade) {
        openConnection();
        entidade = entityManager.merge(entidade);
        entityManager.remove(entidade);
        closeConnection();
    }

    @Override
    public T alterar(T entidade) {
        openConnection();
        entidade = entityManager.merge(entidade);
        closeConnection();
        return entidade;
    }

    @Override
    public T consultar(E valor) {
        openConnection();
        T entidade = entityManager.find(this.persistenteClass, valor);
        closeConnection();
        return entidade;
    }

    @Override
    public Collection<T> buscarTodos() {
        String nomeClasse = persistenteClass.getSimpleName();
        openConnection();
        List<T> entidades = entityManager
                .createQuery("SELECT e FROM " + nomeClasse + " e", this.persistenteClass)
                .getResultList();
        closeConnection();
        return entidades;
    }
}
