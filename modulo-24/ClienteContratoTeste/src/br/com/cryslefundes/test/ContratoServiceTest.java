package br.com.cryslefundes.test;

import br.com.cryslefundes.main.dao.ContratoDao;
import br.com.cryslefundes.main.IContrato;
import br.com.cryslefundes.main.dao.mock.ContratoDaoMock;
import br.com.cryslefundes.main.service.ContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {
    // Testes na funcao Salvar
    @Test
    public void validaSalvarContrato() {
        IContrato contratoDao = new ContratoDaoMock();
        ContratoService contratoService = new ContratoService(contratoDao);
        String retornoFuncSalvar = contratoService.salvar();
        Assert.assertEquals("Salvo com sucesso!", retornoFuncSalvar);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void esperaErroSalvarContrato() {
        IContrato contratoDao = new ContratoDao();
        ContratoService contratoService = new ContratoService(contratoDao);
        String retornoFuncSalvar = contratoService.salvar();
        Assert.assertEquals("Salvo com sucesso!", retornoFuncSalvar);
    }

    // Testes na funcao Buscar
    @Test
    public void validaBuscarContrato() {
        IContrato contratoDao = new ContratoDaoMock();
        ContratoService contratoService = new ContratoService(contratoDao);
        String retornoFuncBuscar = contratoService.buscar();
        Assert.assertEquals("Busca de contrato concluida!", retornoFuncBuscar);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void esperaErroBuscarContrato() {
        IContrato contratoDao = new ContratoDao();
        ContratoService contratoService = new ContratoService(contratoDao);
        String retornoFuncBuscar = contratoService.buscar();
        Assert.assertEquals("Busca de contrato concluida!", retornoFuncBuscar);
    }

    // Testes na funcao Excluir
    @Test
    public void validaExcluirContrato() {
        IContrato contratoDao = new ContratoDaoMock();
        ContratoService contratoService = new ContratoService(contratoDao);
        String retornoFuncExcluir = contratoService.excluir();
        Assert.assertEquals("Excluido com sucesso!", retornoFuncExcluir);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void esperaErroExcluirContrato() {
        IContrato contratoDao = new ContratoDao();
        ContratoService contratoService = new ContratoService(contratoDao);
        String retornoFuncExcluir = contratoService.excluir();
        Assert.assertEquals("Excluido com sucesso!", retornoFuncExcluir);
    }

    // Testes na funcao Atualizar
    @Test
    public void validaAtualizarContrato() {
        IContrato contratoDao = new ContratoDaoMock();
        ContratoService contratoService = new ContratoService(contratoDao);
        String retornoFuncAtualizar = contratoService.atualizar();
        Assert.assertEquals("Atualizado com sucesso!", retornoFuncAtualizar);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void esperaErroAtualizarContrato() {
        IContrato contratoDao = new ContratoDao();
        ContratoService contratoService = new ContratoService(contratoDao);
        String retornoFuncAtualizar = contratoService.atualizar();
        Assert.assertEquals("Atualizado com sucesso!", retornoFuncAtualizar);
    }
}
