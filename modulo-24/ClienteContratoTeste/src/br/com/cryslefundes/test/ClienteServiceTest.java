package br.com.cryslefundes.test;

import br.com.cryslefundes.main.dao.ClienteDao;
import br.com.cryslefundes.main.ICliente;
import br.com.cryslefundes.main.dao.mock.ClienteDaoMock;
import br.com.cryslefundes.main.service.ClienteService;
import org.junit.Assert;
import org.junit.Test;

public class ClienteServiceTest {
    // Testes na funcao Salvar
    @Test
    public void validaSalvarCliente() {
        ICliente clienteDaoMock = new ClienteDaoMock();
        ClienteService clienteService = new ClienteService(clienteDaoMock);
        String retornoFuncSalvar = clienteService.salvar();
        Assert.assertEquals("Cliente salvo com sucesso!", retornoFuncSalvar);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void esperaErroSalvarCliente() {
        ICliente clienteDao = new ClienteDao();
        ClienteService clienteService = new ClienteService(clienteDao);
        String retornoFuncSalvar = clienteService.salvar();
        Assert.assertEquals("Cliente salvo com sucesso!", retornoFuncSalvar);
    }

    // Testes na funcao Buscar
    @Test
    public void validaBuscarCliente() {
        ICliente clienteDaoMock = new ClienteDaoMock();
        ClienteService clienteService = new ClienteService(clienteDaoMock);
        String retornoFuncBuscar = clienteService.buscar();
        Assert.assertEquals("Busca de cliente concluida!", retornoFuncBuscar);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void esperaErroBuscarCliente() {
        ICliente clienteDao = new ClienteDao();
        ClienteService clienteService = new ClienteService(clienteDao);
        String retornoFuncBuscar = clienteService.buscar();
        Assert.assertEquals("Busca de cliente concluida!", retornoFuncBuscar);
    }

    // Testes na funcao Excluir
    @Test
    public void validaExcluirCliente() {
        ICliente clienteDaoMock = new ClienteDaoMock();
        ClienteService clienteService = new ClienteService(clienteDaoMock);
        String retornoFuncExcluir = clienteService.excluir();
        Assert.assertEquals("Cliente excluido com sucesso!", retornoFuncExcluir);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void esperaErroExcluirCliente() {
        ICliente clienteDao = new ClienteDao();
        ClienteService clienteService = new ClienteService(clienteDao);
        String retornoFuncExcluir = clienteService.excluir();
        Assert.assertEquals("Cliente excluido com sucesso!", retornoFuncExcluir);
    }

    // Testes na funcao Atualizar
    @Test
    public void validaAtualizarCliente() {
        ICliente clienteDaoMock = new ClienteDaoMock();
        ClienteService clienteService = new ClienteService(clienteDaoMock);
        String retornoFuncAtualizar = clienteService.atualizar();
        Assert.assertEquals("Cliente atualizado com sucesso!", retornoFuncAtualizar);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void esperaErroAtualizarCliente() {
        ICliente clienteDao = new ClienteDao();
        ClienteService clienteService = new ClienteService(clienteDao);
        String retornoFuncAtualizar = clienteService.atualizar();
        Assert.assertEquals("Cliente atualizado com sucesso!", retornoFuncAtualizar);
    }
}