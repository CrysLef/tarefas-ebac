package br.com.cryslefundes.main.service;

import br.com.cryslefundes.main.ICliente;

public class ClienteService implements ICliente {
    ICliente cliente;

    public ClienteService(ICliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String salvar() {
        cliente.salvar();
        return "Cliente salvo com sucesso!";
    }

    @Override
    public String buscar() {
        cliente.buscar();
        return "Busca de cliente concluida!";
    }

    @Override
    public String excluir() {
        cliente.excluir();
        return "Cliente excluido com sucesso!";
    }

    @Override
    public String atualizar() {
        cliente.atualizar();
        return "Cliente atualizado com sucesso!";
    }
}
