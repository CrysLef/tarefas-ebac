package br.com.cryslefundes.repository.cliente;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.cryslefundes.domain.Cliente;
import br.com.cryslefundes.repository.generic.GenericRepository;

public class ClienteRepository extends GenericRepository<Cliente, Long> implements IClienteRepository{

    public ClienteRepository() {
        super(Cliente.class);
    }

	@Override
	public List<Cliente> filtrarCliente(String query) {
		 TypedQuery<Cliente> typedQuery = this.entityManager.createNamedQuery("Cliente.findByNome", this.persistenteClass);
	        typedQuery.setParameter("nome", "%" + query + "%");
	        return typedQuery.getResultList();
	}
}
