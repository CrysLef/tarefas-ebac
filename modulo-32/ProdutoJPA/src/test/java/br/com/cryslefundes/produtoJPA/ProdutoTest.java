package test.java.br.com.cryslefundes.produtoJPA;

import main.java.br.com.cryslefundes.produtoJPA.domain.Produto;
import main.java.br.com.cryslefundes.produtoJPA.repository.IProdutoRepository;
import main.java.br.com.cryslefundes.produtoJPA.repository.ProdutoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoTest {
    private Produto produto1;
    private Produto produto2;
    private List<Produto> produtos = new ArrayList<>();
    private final IProdutoRepository repository;

    public ProdutoTest() {
        this.repository = new ProdutoRepository();
    }

    @Before
    public void setUp() {
        // PRODUTO 1:
        this.produto1 = new Produto();
        this.produto1.setCodigo("A1B2C3");
        this.produto1.setNome("Iphone 6s");
        this.produto1.setDescricao("Telefone antigo e caro");
        this.produto1.setValor(BigDecimal.valueOf(4199.99));

        // PRODUTO 2:
        this.produto2 = new Produto();
        this.produto2.setCodigo("BA34VC");
        this.produto2.setNome("Garrafa termica");
        this.produto2.setDescricao("Garrafa que mantem a bebida gelada por um mes!");
        this.produto2.setValor(BigDecimal.valueOf(97.99));

        produtos.add(produto1);
        produtos.add(produto2);
    }

    @Test
    public void validaCadastro() {
        produtos.forEach(p -> {
            Produto produtoRegistrado = this.repository.cadastrar(p);
            Assert.assertNotNull(p);
            Assert.assertEquals(p, produtoRegistrado);
        });
    }

    @Test
    public void validaAlteracao() {
        List<Produto> produtosDB = this.repository.buscarTodos();
        Optional<Produto> produtoEncontrado = this.repository.buscarPorId(produto1.getId());
        produtosDB.forEach(p -> {
            if (produtoEncontrado.isPresent()) {
                Produto produto = produtoEncontrado.get();
                Assert.assertEquals(p.getId(), produto.getId());

                produto.setValor(BigDecimal.valueOf(5499.99));
                Produto produtoAlterado = this.repository.alterar(produto);

                Assert.assertEquals(BigDecimal.valueOf(5499.99), produtoAlterado.getValor());
            }
        });
    }

    @Test
    public void validaBuscaPorId() {
        List<Produto> produtosDB = this.repository.buscarTodos();
        for (Produto p : produtosDB) {
            Optional<Produto> produtoEncontrado = this.repository.buscarPorId(p.getId());
            if (produtoEncontrado.isPresent()) {
                Produto produto = produtoEncontrado.get();
                Assert.assertEquals(p.getId(), produto.getId());
            }
        }
    }

    @Test
    public void validaBuscaPorTodos() {
        List<Produto> produtosDB = this.repository.buscarTodos();
        Assert.assertNotNull(produtosDB);
    }

    @Test
    public void validaExclusao() {
        List<Produto> produtosDB = this.repository.buscarTodos();
        for (Produto p : produtosDB) {
            Produto produtoExcluido = this.repository.excluir(p);
            Assert.assertEquals(p.getId(), produtoExcluido.getId());
        }
    }
}