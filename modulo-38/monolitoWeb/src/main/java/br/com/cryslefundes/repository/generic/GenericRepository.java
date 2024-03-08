package br.com.cryslefundes.repository.generic;

import java.io.Serializable;

import java.util.*;

import br.com.cryslefundes.repository.Persistente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericRepository<T extends Persistente, E extends Serializable> implements IGenericRepository<T, E> {
    
	
	@PersistenceContext
    protected EntityManager entityManager;
    
    protected Class<T> persistenteClass;

    public GenericRepository(Class<T> persistenteClass) {
        this.persistenteClass = persistenteClass;
    }


    @Override
    public T cadastrar(T entidade) {
        entityManager.persist(entidade);
        return entidade;
    }

    @Override
    public void excluir(T entidade) {
        entidade = entityManager.merge(entidade);
        entityManager.remove(entidade);
    }

    @Override
    public T alterar(T entidade) {
        entidade = entityManager.merge(entidade);
        return entidade;
    }

    @Override
    public T consultar(E valor) {
        T entidade = entityManager.find(this.persistenteClass, valor);
        return entidade;
    }

    @Override
    public Collection<T> buscarTodos() {
        String nomeClasse = persistenteClass.getSimpleName();

        List<T> entidades = entityManager
                .createQuery("SELECT e FROM " + nomeClasse + " e", this.persistenteClass)
                .getResultList();
        return entidades;
    }
}
