package com.lojaDeComputadorV3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lojaDeComputadorV3.dao.ClienteDAO;
import com.lojaDeComputadorV3.domain.Cliente;
import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteBean {

    private EntidadeDominio clienteCadastro;
	private List<EntidadeDominio> listaCliente;
	private List<EntidadeDominio> listaClienteFiltrados;
	private String acao;
	private Long codigo;
	private EntidadeDominio entidade;
	
	public EntidadeDominio getClienteCadastro() {
		return clienteCadastro;
	}
	public void setClienteCadastro(EntidadeDominio clienteCadastro) {
		this.clienteCadastro = clienteCadastro;
	}
	public List<EntidadeDominio> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(List<EntidadeDominio> listaCliente) {
		this.listaCliente = listaCliente;
	}
	public List<EntidadeDominio> getListaClienteFiltrados() {
		return listaClienteFiltrados;
	}
	public void setListaClienteFiltrados(List<EntidadeDominio> listaClienteFiltrados) {
		this.listaClienteFiltrados = listaClienteFiltrados;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public EntidadeDominio getEntidade() {
		return entidade;
	}
	public void setEntidade(EntidadeDominio entidade) {
		this.entidade = entidade;
	}
	
	public void carregar() {
		try {
			ClienteDAO clidao = new ClienteDAO();
			listaCliente = clidao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar listar os clientes");
		}
	}

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				ClienteDAO clidao = new ClienteDAO();
				clienteCadastro = clidao.buscarPorCodigo(codigo);

			} else {
				clienteCadastro = new Cliente();
			}
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados dos clientes");
		}
	}

	public void novo() {
		clienteCadastro = new Cliente();
	}

	public void salvar() {
		try {
			ClienteDAO clidao = new ClienteDAO();
			clidao.salvar(clienteCadastro);

			FacesUtil.addMsgInfo("Cliente salvo com Sucesso");

			this.clienteCadastro = new Cliente();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar incluir um Cliente");
		}
	}

	public void excluir() {
		try {
			ClienteDAO clidao = new ClienteDAO();
			clidao.excluir(clienteCadastro);

			FacesUtil.addMsgInfo("Cliente removido com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar remover um Cliente");
		}
	}

	public void editar() {
		try {
			ClienteDAO clidao = new ClienteDAO();
			clidao.editar(clienteCadastro);

			FacesUtil.addMsgInfo("Cliente editado com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar editar um Cliente");
		}
	}
	
	
}
