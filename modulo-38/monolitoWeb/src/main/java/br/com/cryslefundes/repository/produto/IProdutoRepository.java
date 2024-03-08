package br.com.cryslefundes.repository.produto;

import java.util.List;

import br.com.cryslefundes.domain.Produto;
import br.com.cryslefundes.repository.generic.IGenericRepository;

public interface IProdutoRepository extends IGenericRepository<Produto, Long> {
	List<Produto> filtrarProduto(String query);
}
