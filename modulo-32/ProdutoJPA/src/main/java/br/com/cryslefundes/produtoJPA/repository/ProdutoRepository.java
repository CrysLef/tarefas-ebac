package main.java.br.com.cryslefundes.produtoJPA.repository;

import main.java.br.com.cryslefundes.produtoJPA.domain.Produto;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ProdutoRepository implements IProdutoRepository {

    @Override
    public Produto cadastrar(Produto produto) {
        EntityManager entityManager = SingletonEntityManager.getInstance();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        SingletonEntityManager.closeInstance();

        return produto;
    }

    @Override
    public Produto excluir(Produto produto) {
        EntityManager entityManager = SingletonEntityManager.getInstance();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        SingletonEntityManager.closeInstance();
        return produto;
    }

    @Override
    public Produto alterar(Produto produto) {
        EntityManager entityManager = SingletonEntityManager.getInstance();
        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.getTransaction().commit();

        SingletonEntityManager.closeInstance();
        return produto;
    }

    @Override
    public List<Produto> buscarTodos() {
        EntityManager entityManager = SingletonEntityManager.getInstance();

        entityManager.getTransaction().begin();
        List<Produto> produtos = entityManager.createQuery("SELECT p FROM Produto p").getResultList();
        entityManager.getTransaction().commit();

        SingletonEntityManager.closeInstance();
        return produtos;
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        EntityManager entityManager = SingletonEntityManager.getInstance();

        entityManager.getTransaction().begin();
        Optional<Produto> produto = Optional.ofNullable(entityManager.find(Produto.class, id));
        entityManager.getTransaction().commit();

        SingletonEntityManager.closeInstance();

        return produto;
    }

}
