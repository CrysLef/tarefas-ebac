package br.com.cryslefundes.domain.useCase;

import java.util.List;

import br.com.cryslefundes.domain.Cliente;

public interface ClienteUseCase extends GenericUseCase<Cliente, Long> {
	List<Cliente> filtrarCliente(String query);
}
