package br.com.cryslefundes.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable {

	private static final long serialVersionUID = -4697978077149642848L;

	public String redirectCliente() {
		return "/clientes/cadastro.xhtml";
	}
	
	public String redirectProduto() {
		return "/produtos/cadastro.xhtml";
	}
	
	public String redirectVenda() {
		return "/vendas/dashboard.xhtml";
	}
	
	
	
}
