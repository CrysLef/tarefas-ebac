package br.com.cryslefundes.repository.cliente;

import java.util.List;

import br.com.cryslefundes.domain.Cliente;
import br.com.cryslefundes.repository.generic.IGenericRepository;

public interface IClienteRepository extends IGenericRepository<Cliente, Long> {
	List<Cliente> filtrarCliente(String query);
}
