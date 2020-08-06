package com.lojaDeComputadorV3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lojaDeComputadorV3.dao.ClienteDAO;
import com.lojaDeComputadorV3.dao.TelefoneDAO;
import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.domain.Telefone;
import com.lojaDeComputadorV3.util.FacesUtil;

@ManagedBean
@ViewScoped
public class TelefoneBean {

	
	private EntidadeDominio telefoneCadastro;
	private List<EntidadeDominio> listaTelefone;
	private List<EntidadeDominio> listaTelefoneFiltrados;
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
	public EntidadeDominio getTelefoneCadastro() {
		return telefoneCadastro;
	}
	public void setTelefoneCadastro(EntidadeDominio telefoneCadastro) {
		this.telefoneCadastro = telefoneCadastro;
	}
	public List<EntidadeDominio> getListaTelefone() {
		return listaTelefone;
	}
	public void setListaTelefone(List<EntidadeDominio> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}
	public List<EntidadeDominio> getListaTelefoneFiltrados() {
		return listaTelefoneFiltrados;
	}
	public void setListaTelefoneFiltrados(List<EntidadeDominio> listaTelefoneFiltrados) {
		this.listaTelefoneFiltrados = listaTelefoneFiltrados;
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
			TelefoneDAO teledao = new TelefoneDAO();
			listaTelefone = teledao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar listar os cartões");
		}
	}

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				TelefoneDAO teledao = new TelefoneDAO();
				telefoneCadastro = teledao.buscarPorCodigo(codigo);

			} else {
				telefoneCadastro = new Telefone();
			}
			ClienteDAO clidao = new ClienteDAO();
			listaCliente = clidao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados dos cartões");
		}
	}

	public void novo() {
		telefoneCadastro = new Telefone();
	}

	public void salvar() {
		try {
			TelefoneDAO teledao = new TelefoneDAO();
			teledao.salvar(telefoneCadastro);

			FacesUtil.addMsgInfo("Cartão salvo com Sucesso");

			this.telefoneCadastro = new Telefone();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar incluir um cartão");
		}
	}

	public void excluir() {
		try {
			TelefoneDAO teledao = new TelefoneDAO();
			teledao.excluir(telefoneCadastro);

			FacesUtil.addMsgInfo("Cartão removido com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar remover um cartão");
		}
	}

	public void editar() {
		try {
			TelefoneDAO teledao = new TelefoneDAO();
			teledao.editar(telefoneCadastro);

			FacesUtil.addMsgInfo("Cartão editado com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar editar um cartão");
		}
	}
}
