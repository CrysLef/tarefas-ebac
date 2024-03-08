package br.com.cryslefundes.domain.useCase;

import br.com.cryslefundes.domain.Venda;

public interface VendaUseCase extends GenericUseCase<Venda, Long> {
	 Venda finalizarVenda(Venda venda);
	 Venda cancelarVenda(Venda venda);
	 Venda consultaLazy(Long id);
}
