package main.java.br.com.cryslefundes.repository.generic;

import java.io.Serializable;
import java.util.List;

public interface IGenericRepository<T, E extends Serializable> {
    T cadastrar(T entidade);
    List<T> buscarTodos();
    void excluir(T entidade);
}
