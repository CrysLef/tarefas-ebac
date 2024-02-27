package test.java.br.com.cryslefundes;


import main.java.br.com.cryslefundes.domain.Acessorio;
import main.java.br.com.cryslefundes.domain.Carro;
import main.java.br.com.cryslefundes.domain.Marca;
import main.java.br.com.cryslefundes.repository.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MarcaRepositoryTest {
    IMarcaRepository repository = new MarcaRepository();
    IAcessorioRepository acessorioRepository = new AcessorioRepository();
    CarroRepository carroRepository = new CarroRepository();

    Marca marca = new Marca();

    @Before
    public void setUp() {
        this.marca.setNome("Subaru");
        this.marca.add(getCarro());
        this.marca.setDataDeCriacao(LocalDate.now());

    }

    @Test
    public void validaCadastrar() {
        Marca marcaCadastrada = this.repository.cadastrar(marca);
        Assert.assertNotNull(marcaCadastrada);
    }

    @Test
    public void validaBuscarTodos() {
        List<Marca> marcas = this.repository.buscarTodos();
        Assert.assertNotNull(marcas);
    }

    @Test
    public void validaExcluir() {
        List<Marca> marcas = this.repository.buscarTodos();
        marcas.forEach(this.repository::excluir);

        List<Carro> carros = this.carroRepository.buscarTodos();
        carros.forEach(this.carroRepository::excluir);

        List<Acessorio> acessorios = this.acessorioRepository.buscarTodos();
        acessorios.forEach(this.acessorioRepository::excluir);
    }

    private Carro getCarro() {
        Carro carro = new Carro();
        carro.setNome("Impreza");
        carro.setAno(2012);
        carro.add(getAcessorio());
        return carroRepository.cadastrar(carro);
    }

    private Acessorio getAcessorio() {
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("estepe");
        acessorio.setValor(142.87);

        return this.acessorioRepository.cadastrar(acessorio);
    }

}