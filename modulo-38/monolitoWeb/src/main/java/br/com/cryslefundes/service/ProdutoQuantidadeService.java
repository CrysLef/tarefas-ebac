package br.com.cryslefundes.service;

import br.com.cryslefundes.domain.ProdutoQuantidade;
import br.com.cryslefundes.domain.useCase.ProdutoQuantidadeUseCase;
import br.com.cryslefundes.repository.produtoQuantidade.IProdutoQuantidadeRepository;


public class ProdutoQuantidadeService extends GenericService<ProdutoQuantidade, Long> implements ProdutoQuantidadeUseCase {
    public ProdutoQuantidadeService(IProdutoQuantidadeRepository produtoQuantidadeRepository) {
        super(produtoQuantidadeRepository);
    }
}
