package br.com.cryslefundes.service;

import java.util.List;

import br.com.cryslefundes.domain.Produto;
import br.com.cryslefundes.domain.useCase.ProdutoUseCase;
import br.com.cryslefundes.repository.produto.IProdutoRepository;

public class ProdutoService extends GenericService<Produto, Long> implements ProdutoUseCase {
	
	private IProdutoRepository produtoRepository;
	
    public ProdutoService(IProdutoRepository produtoRepository) {
        super(produtoRepository);
        this.produtoRepository = produtoRepository;
    }

	@Override
	public List<Produto> filtrarProduto(String query) {
		return produtoRepository.filtrarProduto(query);
	}
}
