package test.java.br.com.cryslefundes;

import main.java.br.com.cryslefundes.domain.Acessorio;
import main.java.br.com.cryslefundes.domain.Carro;
import main.java.br.com.cryslefundes.domain.Marca;
import main.java.br.com.cryslefundes.repository.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;


public class CarroRepositoryTest {
    ICarroRepository repository = new CarroRepository();
    IMarcaRepository marcaRepository = new MarcaRepository();
    IAcessorioRepository acessorioRepository = new AcessorioRepository();
    Carro carro = new Carro();

    @Before
    public void setUp() {
        this.carro.setNome("Impreza");
        this.carro.setAno(2012);
        this.carro.add(getAcessorio());
        this.carro.setMarca(getMarca());
    }

    @Test
    public void validaCadastrar() {
        Carro carroCadastrado = this.repository.cadastrar(carro);
        Assert.assertNotNull(carroCadastrado);
    }

    @Test
    public void validaBuscarTodos() {
        List<Carro> carros = this.repository.buscarTodos();
        Assert.assertNotNull(carros);
    }

    @Test
    public void validaExcluir() {
        List<Carro> carros = this.repository.buscarTodos();
        carros.forEach(this.repository::excluir);

        List<Marca> marcas = this.marcaRepository.buscarTodos();
        marcas.forEach(this.marcaRepository::excluir);

        List<Acessorio> acessorios = this.acessorioRepository.buscarTodos();
        acessorios.forEach(this.acessorioRepository::excluir);
    }


    private Marca getMarca() {
        Marca marca = new Marca();
        marca.setNome("Subaru");
        marca.setDataDeCriacao(LocalDate.now());
        return this.marcaRepository.cadastrar(marca);
    }

    private Acessorio getAcessorio() {
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("estepe");
        acessorio.setValor(142.87);

        return this.acessorioRepository.cadastrar(acessorio);
    }



}