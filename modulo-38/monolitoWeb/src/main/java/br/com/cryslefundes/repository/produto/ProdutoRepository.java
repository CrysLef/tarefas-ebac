package br.com.cryslefundes.repository.produto;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.cryslefundes.domain.Produto;
import br.com.cryslefundes.repository.generic.GenericRepository;

public class ProdutoRepository extends GenericRepository<Produto, Long> implements IProdutoRepository {

    public ProdutoRepository() {
        super(Produto.class);
    }

	@Override
	public List<Produto> filtrarProduto(String query) {
		TypedQuery<Produto> typedQuery = this.entityManager.createNamedQuery("Produto.findByNome", this.persistenteClass);
        typedQuery.setParameter("nome", "%" + query + "%");
        return typedQuery.getResultList();
	}
}
