package com.lojaDeComputadorV3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lojaDeComputadorV3.dao.ProdutoDAO;
import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.domain.Produto;
import com.lojaDeComputadorV3.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean{
	
	private EntidadeDominio produtoCadastro;
	private List<EntidadeDominio> listaProdutos;
	private List<EntidadeDominio> listaProdutosFiltrados;
	private String acao;
	private Long codigo;
	private EntidadeDominio entidade;
	
	public EntidadeDominio getProdutoCadastro() {
		return produtoCadastro;
	}
	public void setProdutoCadastro(EntidadeDominio produtoCadastro) {
		this.produtoCadastro = produtoCadastro;
	}
	public List<EntidadeDominio> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<EntidadeDominio> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public List<EntidadeDominio> getListaProdutosFiltrados() {
		return listaProdutosFiltrados;
	}
	public void setListaProdutosFiltrados(List<EntidadeDominio> listaProdutosFiltrados) {
		this.listaProdutosFiltrados = listaProdutosFiltrados;
	}
	public EntidadeDominio getEntidade() {
		return entidade;
	}
	public void setEntidade(EntidadeDominio entidade) {
		this.entidade = entidade;
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
	
	public void carregar() {
		try {
			ProdutoDAO proddao = new ProdutoDAO();
			listaProdutos = proddao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar listar os produtos");
		}
	}

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				ProdutoDAO proddao = new ProdutoDAO();
				produtoCadastro = proddao.buscarPorCodigo(codigo);

			} else {
				produtoCadastro = new Produto();
			}
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados dos produtos");
		}
	}

	public void novo() {
		produtoCadastro = new Produto();
	}

	public void salvar() {
		try {
			ProdutoDAO proddao = new ProdutoDAO();
			proddao.salvar(produtoCadastro);

			FacesUtil.addMsgInfo("Produto salvo com Sucesso");

			this.produtoCadastro = new Produto();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar incluir um produto");
		}
	}

	public void excluir() {
		try {
			ProdutoDAO proddao = new ProdutoDAO();
			proddao.excluir(produtoCadastro);

			FacesUtil.addMsgInfo("Produto removido com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar remover um produto");
		}
	}

	public void editar() {
		try {
			ProdutoDAO proddao = new ProdutoDAO();
			proddao.editar(produtoCadastro);

			FacesUtil.addMsgInfo("Produto editado com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar editar um produto");
		}
	}
	
}
