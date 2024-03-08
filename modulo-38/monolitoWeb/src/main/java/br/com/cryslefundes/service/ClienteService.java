package br.com.cryslefundes.service;

import java.util.List;

import br.com.cryslefundes.domain.Cliente;
import br.com.cryslefundes.domain.useCase.ClienteUseCase;
import br.com.cryslefundes.repository.cliente.IClienteRepository;

public class ClienteService extends GenericService<Cliente, Long> implements ClienteUseCase {

    private IClienteRepository clienteRepository;
	
	public ClienteService(IClienteRepository clienteRepository) {
        super(clienteRepository);
		this.clienteRepository = clienteRepository;
    }

	@Override
	public List<Cliente> filtrarCliente(String query) {
		return this.clienteRepository.filtrarCliente(query);
	}
}
