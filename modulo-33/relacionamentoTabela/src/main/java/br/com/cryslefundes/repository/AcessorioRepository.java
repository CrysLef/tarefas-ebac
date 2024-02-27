package main.java.br.com.cryslefundes.repository;

import main.java.br.com.cryslefundes.domain.Acessorio;
import main.java.br.com.cryslefundes.repository.generic.GenericRepository;

import javax.persistence.Table;

public class AcessorioRepository extends GenericRepository<Acessorio, Long> implements IAcessorioRepository {
    @Override
    protected String getTableName() {
        return Acessorio.class.getSimpleName();
    }
}
