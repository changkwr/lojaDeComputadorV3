package com.lojaDeComputadorV3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lojaDeComputadorV3.dao.ClienteDAO;
import com.lojaDeComputadorV3.dao.EnderecoDAO;
import com.lojaDeComputadorV3.domain.Endereco;
import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.util.FacesUtil;

@ManagedBean
@ViewScoped
public class EnderecoBean {
	
	private EntidadeDominio enderecoCadastro;
	private List<EntidadeDominio> listaEndereco;
	private List<EntidadeDominio> listaEnderecoFiltrados;
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

	public EntidadeDominio getEnderecoCadastro() {
		return enderecoCadastro;
	}

	public void setEnderecoCadastro(EntidadeDominio enderecoCadastro) {
		this.enderecoCadastro = enderecoCadastro;
	}

	public List<EntidadeDominio> getListaEndereco() {
		return listaEndereco;
	}

	public void setListaEndereco(List<EntidadeDominio> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}

	public List<EntidadeDominio> getListaEnderecoFiltrados() {
		return listaEnderecoFiltrados;
	}

	public void setListaEnderecoFiltrados(List<EntidadeDominio> listaEnderecoFiltrados) {
		this.listaEnderecoFiltrados = listaEnderecoFiltrados;
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
			EnderecoDAO enddao = new EnderecoDAO();
			listaEndereco = enddao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar listar os endereços");
		}
	}

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				EnderecoDAO enddao = new EnderecoDAO();
				enderecoCadastro = enddao.buscarPorCodigo(codigo);

			} else {
				enderecoCadastro = new Endereco();
			}
			ClienteDAO clidao = new ClienteDAO();
			listaCliente = clidao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados dos endereços");
		}
	}

	public void novo() {
		enderecoCadastro = new Endereco();
	}

	public void salvar() {
		try {
			EnderecoDAO enddao = new EnderecoDAO();
			enddao.salvar(enderecoCadastro);

			FacesUtil.addMsgInfo("Endereço salvo com Sucesso");

			this.enderecoCadastro = new Endereco();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar incluir um Endereço");
		}
	}

	public void excluir() {
		try {
			EnderecoDAO enddao = new EnderecoDAO();
			enddao.excluir(enderecoCadastro);

			FacesUtil.addMsgInfo("Endereço removido com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar remover um Endereço");
		}
	}

	public void editar() {
		try {
			EnderecoDAO enddao = new EnderecoDAO();
			enddao.editar(enderecoCadastro);

			FacesUtil.addMsgInfo("Endereço editado com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar editar um Endereço");
		}
	}

}
