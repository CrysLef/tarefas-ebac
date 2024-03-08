package br.com.cryslefundes.repository.produtoQuantidade;

import br.com.cryslefundes.domain.ProdutoQuantidade;
import br.com.cryslefundes.repository.generic.GenericRepository;

public class ProdutoQuantidadeRepository extends GenericRepository<ProdutoQuantidade, Long> implements IProdutoQuantidadeRepository {
    public ProdutoQuantidadeRepository() { super(ProdutoQuantidade.class); }
}
