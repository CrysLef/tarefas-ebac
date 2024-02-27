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


public class AcessorioRepositoryTest {
    IAcessorioRepository repository = new AcessorioRepository();

    IMarcaRepository marcaRepository = new MarcaRepository();
    CarroRepository carroRepository = new CarroRepository();
    Acessorio acessorio = new Acessorio();

    @Before
    public void setUp() {
        acessorio.setNome("estepe");
        acessorio.setValor(123999.99);
        acessorio.add(getCarro());
    }

    @Test
    public void validaCadastrar() {
        Acessorio acessorioCadastrado = this.repository.cadastrar(this.acessorio);
        Assert.assertNotNull(acessorioCadastrado);
    }

    @Test
    public void validaBuscarTodos() {
        List<Acessorio> acessorios = this.repository.buscarTodos();
        Assert.assertNotNull(acessorios);
    }

    @Test
    public void validaExcluir() {
        List<Acessorio> marcas = this.repository.buscarTodos();
        marcas.forEach(this.repository::excluir);

        List<Carro> carros = this.carroRepository.buscarTodos();
        carros.forEach(this.carroRepository::excluir);

        List<Marca> acessorios = this.marcaRepository.buscarTodos();
        acessorios.forEach(this.marcaRepository::excluir);
    }


    private Carro getCarro() {
        Carro carro = new Carro();
        carro.setNome("Impreza");
        carro.setAno(2012);
        carro.setMarca(getMarca());
        return carroRepository.cadastrar(carro);
    }

    private Marca getMarca() {
        Marca marca = new Marca();
        marca.setNome("Subaru");
        marca.setDataDeCriacao(LocalDate.now());
        return marcaRepository.cadastrar(marca);
    }

}