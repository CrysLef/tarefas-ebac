package br.com.cryslefundes.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.cryslefundes.domain.Cliente;
import br.com.cryslefundes.domain.useCase.ClienteUseCase;
import br.com.cryslefundes.repository.cliente.ClienteRepository;
import br.com.cryslefundes.repository.cliente.IClienteRepository;
import br.com.cryslefundes.service.ClienteService;

@Named
@ViewScoped
public class ClienteController implements Serializable {

	
	private static final long serialVersionUID = -4442433768160608286L;
	
	private Cliente cliente;
	private Collection<Cliente> clientes;
	private IClienteRepository clienteRepository = new ClienteRepository();
	private ClienteUseCase clienteService = new ClienteService(clienteRepository);
	private Boolean isUpdate;
	private String telefoneMask;
	private String cpfMask;

	@PostConstruct
	public void init() {
		try {
			this.isUpdate = false;
			this.cliente = new Cliente();
			this.clientes = clienteService.buscarTodos();
			
		} catch(Exception ex) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar todos os clientes."));
		}
	}
	
	public void add() {
		try {
			removerCaracteresInvalidos();
			limparCampos();
			clienteService.cadastrar(cliente);
			this.clientes = clienteService.buscarTodos();
			this.cliente = new Cliente();
		} catch(Exception ex) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cadastrar cliente."));
		}
	}
	
	public void edit(Cliente cliente) {
		try {
			this.isUpdate = true;
			this.cliente = cliente;
		} catch(Exception ex) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar editar cliente."));
		}
	}
	
	public void update() {
		try {
			removerCaracteresInvalidos();
			clienteService.alterar(cliente);
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Cliente Atualizado com sucesso"));
		} catch(Exception ex) { 
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar cliente."));
		}
	}
	
	public void delete(Cliente cliente) {
		try {
			clienteService.excluir(cliente);
			clientes.remove(cliente);
		} catch(Exception ex) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir cliente."));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.cliente = new Cliente();
		} catch(Exception ex) { 
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao cancelar ação."));
		}
	}
	
	private String replaceCaracter(String value, String ...patterns) {
		String retorno = value;
		for (String pattern : patterns) {
			retorno = retorno.replace(pattern, "");
		}
		return retorno;
	}
	
	
	private void removerCaracteresInvalidos() {
		Long cpf = Long.valueOf(replaceCaracter(getCpfMask(), ".", "-"));
		this.cliente.setCpf(cpf);
	}
	
	
	private void limparCampos() {
		setCpfMask(null);
		setTelefoneMask(null);
	}
	
	
	public String redirectIndex() {
		return "/index.xhtml";
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getCpfMask() {
		return cpfMask;
	}

	public void setCpfMask(String cpfMask) {
		this.cpfMask = cpfMask;
	}

	public String getTelefoneMask() {
		return telefoneMask;
	}

	public void setTelefoneMask(String telefoneMask) {
		this.telefoneMask = telefoneMask;
	}
	
}
