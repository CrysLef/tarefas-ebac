package br.com.cryslefundes.service;

import br.com.cryslefundes.domain.Venda;
import br.com.cryslefundes.domain.enums.StatusVenda;
import br.com.cryslefundes.domain.useCase.VendaUseCase;
import br.com.cryslefundes.repository.venda.IVendaRepository;

public class VendaService extends GenericService<Venda, Long> implements VendaUseCase {
    private IVendaRepository vendaRepository;
	
	public VendaService(IVendaRepository vendaRepository) {
        super(vendaRepository);
        this.vendaRepository = vendaRepository;
    }

	@Override
	public Venda finalizarVenda(Venda venda) {
		venda.setStatusVenda(StatusVenda.CONCLUIDA);
		return vendaRepository.finalizarVenda(venda);
	}

	@Override
	public Venda cancelarVenda(Venda venda) {
		venda.setStatusVenda(StatusVenda.CANCELADA);
		return vendaRepository.cancelarVenda(venda);
	}

	@Override
	public Venda consultaLazy(Long id) {
		return vendaRepository.consultaLazy(id);
	}
	
	@Override
	public Venda cadastrar(Venda venda) {
		venda.setStatusVenda(StatusVenda.INICIADA);
		return super.cadastrar(venda);
	}
}
