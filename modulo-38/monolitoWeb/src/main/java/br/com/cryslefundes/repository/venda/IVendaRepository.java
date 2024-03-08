package br.com.cryslefundes.repository.venda;

import br.com.cryslefundes.domain.Venda;
import br.com.cryslefundes.repository.generic.IGenericRepository;

public interface IVendaRepository extends IGenericRepository<Venda, Long> {
    Venda finalizarVenda(Venda venda);
    Venda cancelarVenda(Venda venda);
    Venda consultaLazy(Long id);
}
