package br.com.cryslefundes.main.dao;

import br.com.cryslefundes.main.ICliente;

public class ClienteDao implements ICliente {
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
