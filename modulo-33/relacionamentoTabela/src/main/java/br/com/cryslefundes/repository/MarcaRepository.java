package main.java.br.com.cryslefundes.repository;

import main.java.br.com.cryslefundes.domain.Marca;
import main.java.br.com.cryslefundes.repository.generic.GenericRepository;

import javax.persistence.Table;

public class MarcaRepository extends GenericRepository<Marca, Long> implements IMarcaRepository {
    @Override
    protected String getTableName() {
        return Marca.class.getSimpleName();
    }
}
