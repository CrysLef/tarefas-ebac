package main.java.br.com.cryslefundes.produtoJPA.repository;

import main.java.br.com.cryslefundes.produtoJPA.domain.Produto;

import java.util.List;
import java.util.Optional;

public interface IProdutoRepository {
    Produto cadastrar(Produto produto);

    Produto excluir(Produto produto);

    Produto alterar(Produto produto);

    List<Produto> buscarTodos();

    Optional<Produto> buscarPorId(Long id);
}
