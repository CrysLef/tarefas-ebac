package br.com.cryslefundes.main.service;

import br.com.cryslefundes.main.IContrato;

public class ContratoService implements IContrato {
    private IContrato contrato;

    public ContratoService(IContrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public String salvar() {
        contrato.salvar();
        return "Salvo com sucesso!";
    }

    @Override
    public String buscar() {
        contrato.buscar();
        return "Busca de contrato concluida!";
    }

    @Override
    public String excluir() {
        contrato.excluir();
        return "Excluido com sucesso!";
    }

    @Override
    public String atualizar() {
        contrato.atualizar();
        return "Atualizado com sucesso!";
    }
}
