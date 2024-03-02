package main.java.br.com.cryslefundes.dao;

import main.java.br.com.cryslefundes.dao.generic.GenericDAO;
import main.java.br.com.cryslefundes.domain.Cliente;

public class ClienteMysqlDAO extends GenericDAO<Cliente, Long> implements IClienteMysqlDAO {
    public ClienteMysqlDAO() {
        super(Cliente.class, "mysql");
    }

}
