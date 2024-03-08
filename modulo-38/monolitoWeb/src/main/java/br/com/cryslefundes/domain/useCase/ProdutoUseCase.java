package br.com.cryslefundes.domain.useCase;

import java.util.List;

import br.com.cryslefundes.domain.Produto;

public interface ProdutoUseCase extends GenericUseCase<Produto, Long> {
	List<Produto> filtrarProduto(String query);
}
