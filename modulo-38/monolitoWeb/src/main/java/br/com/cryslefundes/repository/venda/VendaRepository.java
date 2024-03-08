package br.com.cryslefundes.repository.venda;

import br.com.cryslefundes.domain.Cliente;
import br.com.cryslefundes.domain.Produto;
import br.com.cryslefundes.domain.Venda;
import br.com.cryslefundes.repository.generic.GenericRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class VendaRepository extends GenericRepository<Venda, Long> implements IVendaRepository{
    public VendaRepository() {
        super(Venda.class);
    }

    @Override
    public Venda cadastrar(Venda entidade) {

        entidade.getProdutos().forEach(p -> {
            Produto produto = entityManager.merge(p.getProduto());
            p.setProduto(produto);
        });

        Cliente cliente = entityManager.merge(entidade.getCliente());
        entidade.setCliente(cliente);

        entityManager.persist(entidade);

        return entidade;
    }

    @Override
    public Venda finalizarVenda(Venda venda) {
        return super.alterar(venda);
    }

    @Override
    public Venda cancelarVenda(Venda venda) {
        return super.alterar(venda);
    }

    @Override
    public Venda consultaLazy(Long id) {

        var criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Venda> query = criteriaBuilder.createQuery(Venda.class);
        Root<Venda> root = query.from(Venda.class);
        root.fetch("cliente");
        root.fetch("produtos");
        query.select(root).where(criteriaBuilder.equal(root.get("id"), id));
        TypedQuery<Venda> typedQuery = entityManager.createQuery(query);
        Venda venda = typedQuery.getSingleResult();

        return venda;
    }
}
