package com.lojaDeComputadorV3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lojaDeComputadorV3.dao.CartaoDAO;
import com.lojaDeComputadorV3.dao.ClienteDAO;
import com.lojaDeComputadorV3.domain.Cartao;
import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CartaoBean {

    private EntidadeDominio cartaoCadastro;
	private List<EntidadeDominio> listaCartao;
	private List<EntidadeDominio> listaCartaoFiltrados;
	private String acao;
	private Long codigo;
	private EntidadeDominio entidade;
	private List<EntidadeDominio> listaCliente;
	
	
	public List<EntidadeDominio> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(List<EntidadeDominio> listaCliente) {
		this.listaCliente = listaCliente;
	}
	public EntidadeDominio getCartaoCadastro() {
		return cartaoCadastro;
	}
	public void setCartaoCadastro(EntidadeDominio cartaoCadastro) {
		this.cartaoCadastro = cartaoCadastro;
	}
	public List<EntidadeDominio> getListaCartao() {
		return listaCartao;
	}
	public void setListaCartao(List<EntidadeDominio> listaCartao) {
		this.listaCartao = listaCartao;
	}
	public List<EntidadeDominio> getListaCartaoFiltrados() {
		return listaCartaoFiltrados;
	}
	public void setListaCartaoFiltrados(List<EntidadeDominio> listaCartaoFiltrados) {
		this.listaCartaoFiltrados = listaCartaoFiltrados;
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
			CartaoDAO carddao = new CartaoDAO();
			listaCartao = carddao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar listar os cartões");
		}
	}

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				CartaoDAO carddao = new CartaoDAO();
				cartaoCadastro = carddao.buscarPorCodigo(codigo);

			} else {
				cartaoCadastro = new Cartao();
			}
			ClienteDAO clidao = new ClienteDAO();
			listaCliente = clidao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados dos cartões");
		}
	}

	public void novo() {
		cartaoCadastro = new Cartao();
	}

	public void salvar() {
		try {
			CartaoDAO carddao = new CartaoDAO();
			carddao.salvar(cartaoCadastro);

			FacesUtil.addMsgInfo("Cartão salvo com Sucesso");

			this.cartaoCadastro = new Cartao();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar incluir um cartão");
		}
	}

	public void excluir() {
		try {
			CartaoDAO carddao = new CartaoDAO();
			carddao.excluir(cartaoCadastro);

			FacesUtil.addMsgInfo("Cartão removido com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar remover um cartão");
		}
	}

	public void editar() {
		try {
			CartaoDAO carddao = new CartaoDAO();
			carddao.editar(cartaoCadastro);

			FacesUtil.addMsgInfo("Cartão editado com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar editar um cartão");
		}
	}
	
	
	
	
	
	
	
	
	
}
