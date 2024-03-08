package br.com.cryslefundes.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.cryslefundes.domain.Produto;
import br.com.cryslefundes.repository.produto.*;
import br.com.cryslefundes.domain.useCase.ProdutoUseCase;
import br.com.cryslefundes.service.ProdutoService;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = -4334552639292410373L;
	
	private Produto produto;
	private Collection<Produto> produtos;
	private IProdutoRepository produtoRepository = new ProdutoRepository();
	private ProdutoUseCase produtoService = new ProdutoService(produtoRepository);
	private Boolean isUpdate;
	
	@PostConstruct
	public void init() {
		try {
			this.isUpdate = false;
			this.produto = new Produto();
			this.produtos = produtoService.buscarTodos();
		} catch(Exception ex) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar todos os produtos."));
		}
	}
	
	public void add() {
		try {			
			produtoService.cadastrar(produto);
			this.produtos = produtoService.buscarTodos();
			this.produto = new Produto();
		} catch(Exception ex) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cadastrar produto."));
		}
	}
	
	public void edit(Produto produto) {
		try {
			this.isUpdate = true;
			this.produto = produto;
		} catch(Exception ex) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar editar produto."));
		}
	}
	
	public void update() {
		try {
			produtoService.alterar(produto);
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Produto Atualizado com sucesso"));
		} catch(Exception ex) { 
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar produto."));
		}
	}
	
	public void delete(Produto produto) {
		try {
			produtoService.excluir(produto);
			produtos.remove(produto);
		} catch(Exception ex) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir produto."));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.produto = new Produto();
		} catch(Exception ex) { 
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao cancelar ação."));
		}
	}
	
	
	public String redirectIndex() {
		return "/index.xhtml";
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
    
}
