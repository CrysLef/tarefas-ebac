package main.java.br.com.cryslefundes.repository;

import main.java.br.com.cryslefundes.domain.Carro;
import main.java.br.com.cryslefundes.repository.generic.GenericRepository;

import javax.persistence.Table;

public class CarroRepository extends GenericRepository<Carro, Long> implements ICarroRepository {
    @Override
    protected String getTableName() {
        return Carro.class.getSimpleName();
    }
}
