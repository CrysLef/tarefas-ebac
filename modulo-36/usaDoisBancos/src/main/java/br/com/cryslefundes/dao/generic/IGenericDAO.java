package main.java.br.com.cryslefundes.dao.generic;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO<T, E extends Serializable> {
    T cadastrar(T entidade);
    void excluir(T entidade);
    T alterar(T entidade);
    T consultar(E valor);
    Collection<T> buscarTodos();
}
