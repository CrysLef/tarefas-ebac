package test.java.br.com.cryslefundes.repository;

import main.java.br.com.cryslefundes.dao.ClienteMysqlDAO;
import main.java.br.com.cryslefundes.dao.ClientePostgresDAO;
import main.java.br.com.cryslefundes.dao.IClienteMysqlDAO;
import main.java.br.com.cryslefundes.dao.IClientePostgresDAO;
import main.java.br.com.cryslefundes.domain.Cliente;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

public class ClienteDAOTest {
    private IClienteMysqlDAO mysqlDAO;
    private IClientePostgresDAO postgresDAO;
    private Random random;

    public ClienteDAOTest() {
        this.mysqlDAO = new ClienteMysqlDAO();
        this.postgresDAO = new ClientePostgresDAO();
        this.random = new Random();
    }

    @After
    public void endTest() {
        Collection<Cliente> clientesPostgres = this.postgresDAO.buscarTodos();
        clientesPostgres.forEach(this.postgresDAO::excluir);

        Collection<Cliente> clientesMysql = this.mysqlDAO.buscarTodos();
        clientesMysql.forEach(this.mysqlDAO::excluir);
    }

    private Cliente createCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Crystian Lefundes");
        cliente.setCpf(random.nextLong());
        cliente.setTelefone("11964134264");
        cliente.setEmail("crystian_lefundes@email.com");
        cliente.setEndereco("Rua dos bobos");
        cliente.setCidade("Sao paulo");
        cliente.setEstado("SP");
        return cliente;
    }

    @Test
    public void validaCadastrar() {
        // Cadastro no PostrgreSQL:
        Cliente clientesPostgres = createCliente();
        Cliente clientePostgresCadastrado = this.postgresDAO.cadastrar(clientesPostgres);
        Assert.assertNotNull(clientePostgresCadastrado);

        // Cadastro no MySQL:
        Cliente clienteMysql = createCliente();
        Cliente clienteMysqlCadastrado = this.mysqlDAO.cadastrar(clienteMysql);
        Assert.assertNotNull(clienteMysqlCadastrado);
    }

    @Test
    public void validaConsultar() {
        // Consulta no PostrgreSQL:
        Cliente clientePostgres = createCliente();
        Cliente clientePostgresCadastrado = this.postgresDAO.cadastrar(clientePostgres);
        Assert.assertNotNull(clientePostgresCadastrado);

        Cliente clientePostgresConsultado = this.postgresDAO.consultar(clientePostgresCadastrado.getId());
        Assert.assertNotNull(clientePostgresConsultado);

        // Consulta no MySQL:
        Cliente clienteMysql = createCliente();
        Cliente clienteMysqlCadastrado = this.mysqlDAO.cadastrar(clienteMysql);
        Assert.assertNotNull(clienteMysqlCadastrado);

        Cliente clienteMysqlConsultado = this.mysqlDAO.consultar(clienteMysqlCadastrado.getId());
        Assert.assertNotNull(clienteMysqlConsultado);
    }

    @Test
    public void validaAlterar() {
        // Alterando no PostgreSQL:
        Cliente clientePostgres = createCliente();
        Cliente clientePostgresCadastrado = this.postgresDAO.cadastrar(clientePostgres);
        Assert.assertNotNull(clientePostgresCadastrado);

        clientePostgresCadastrado.setNome("Ana Maria");
        clientePostgresCadastrado.setEmail("ana_maria@email.com");

        Cliente clientePostgresAlterado = this.postgresDAO.alterar(clientePostgresCadastrado);
        Assert.assertNotNull(clientePostgresAlterado);

        Cliente clientePostgresAlteradoConsultado = this.postgresDAO.consultar(clientePostgresAlterado.getId());
        Assert.assertNotNull(clientePostgresAlteradoConsultado);

        Assert.assertEquals("Ana Maria", clientePostgresAlteradoConsultado.getNome());
        Assert.assertEquals("ana_maria@email.com", clientePostgresAlteradoConsultado.getEmail());

        // Alterando no MySQL:
        Cliente clienteMysql = createCliente();
        Cliente clienteMysqlCadastrado = this.mysqlDAO.cadastrar(clienteMysql);
        Assert.assertNotNull(clienteMysqlCadastrado);

        clienteMysqlCadastrado.setNome("Ana Maria");
        clienteMysqlCadastrado.setEmail("ana_maria@email.com");

        Cliente clienteMysqlAlterado = this.mysqlDAO.alterar(clienteMysqlCadastrado);
        Assert.assertNotNull(clienteMysqlAlterado);

        Cliente clienteMysqlAlteradoConsultado = this.mysqlDAO.consultar(clienteMysqlAlterado.getId());
        Assert.assertNotNull(clienteMysqlAlteradoConsultado);

        Assert.assertEquals("Ana Maria", clienteMysqlAlteradoConsultado.getNome());
        Assert.assertEquals("ana_maria@email.com", clienteMysqlAlteradoConsultado.getEmail());
    }

    @Test
    public void validaBuscarTodos() {
        // Buscando todos no PostgreSQL:
        Cliente clientePostgres = createCliente();
        Cliente clientePostgresCadastrado = this.postgresDAO.cadastrar(clientePostgres);
        Assert.assertNotNull(clientePostgresCadastrado);

        Cliente clientePostgres2 = createCliente();
        Cliente clientePostgres2Cadastrado = this.postgresDAO.cadastrar(clientePostgres2);
        Assert.assertNotNull(clientePostgres2Cadastrado);

        Collection<Cliente> clientesPostgres = this.postgresDAO.buscarTodos();
        Assert.assertNotNull(clientesPostgres);
        Assert.assertEquals(2, clientesPostgres.size());

        // Buscando todos no MySQL:
        Cliente clienteMysql = createCliente();
        Cliente clienteMysqlCadastrado = this.mysqlDAO.cadastrar(clienteMysql);
        Assert.assertNotNull(clienteMysqlCadastrado);

        Cliente clienteMysql2 = createCliente();
        Cliente clienteMysql2Cadastrado = this.mysqlDAO.cadastrar(clienteMysql2);
        Assert.assertNotNull(clienteMysql2Cadastrado);

        Collection<Cliente> clientesMysql = this.mysqlDAO.buscarTodos();
        Assert.assertNotNull(clientesMysql);
        Assert.assertEquals(2, clientesMysql.size());
    }

    @Test
    public void validaExcluir() {
        // Exclindo PostgresSQL:
        Cliente clientePostgres = createCliente();
        Cliente clientePostgresCadastrado = this.postgresDAO.cadastrar(clientePostgres);
        Assert.assertNotNull(clientePostgresCadastrado);

        Collection<Cliente> clientesPostgres = this.postgresDAO.buscarTodos();
        clientesPostgres.forEach(this.postgresDAO::excluir);

        // Excluindo no MySQL:
        Cliente clienteMysql = createCliente();
        Cliente clienteMysqlCadastrado = this.mysqlDAO.cadastrar(clienteMysql);
        Assert.assertNotNull(clienteMysqlCadastrado);

        Collection<Cliente> clientesMysql = this.mysqlDAO.buscarTodos();
        clientesMysql.forEach(this.mysqlDAO::excluir);
    }
}
