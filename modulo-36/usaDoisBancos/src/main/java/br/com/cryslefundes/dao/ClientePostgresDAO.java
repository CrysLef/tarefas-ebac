package main.java.br.com.cryslefundes.dao;

import main.java.br.com.cryslefundes.dao.generic.GenericDAO;
import main.java.br.com.cryslefundes.domain.Cliente;

public class ClientePostgresDAO extends GenericDAO<Cliente, Long> implements IClientePostgresDAO {

    public ClientePostgresDAO() {
        super(Cliente.class, "postgres");
    }
}
