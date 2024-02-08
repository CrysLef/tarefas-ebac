package br.com.cryslefundes.main.dao;

import br.com.cryslefundes.main.IContrato;

public class ContratoDao implements IContrato {
    @Override
    public String salvar() {
        throw new UnsupportedOperationException("Banco de dados sem configuração!");
    }

    @Override
    public String buscar() {
        throw new UnsupportedOperationException("Banco de dados sem configuração!");
    }

    @Override
    public String excluir() {
        throw new UnsupportedOperationException("Banco de dados sem configuração!");
    }

    @Override
    public String atualizar() {
        throw new UnsupportedOperationException("Banco de dados sem configuração!");
    }
}
