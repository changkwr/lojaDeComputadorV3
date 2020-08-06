package com.lojaDeComputadorV3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lojaDeComputadorV3.dao.ComputadorDAO;
import com.lojaDeComputadorV3.dao.ProdutoDAO;
import com.lojaDeComputadorV3.domain.Computador;
import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ComputadorBean {
	
	 private EntidadeDominio computadorCadastro;
		private List<EntidadeDominio> listaComputador;
		private List<EntidadeDominio> listaComputadorFiltrados;
		private String acao;
		private Long codigo;
		private EntidadeDominio entidade;
		private List<EntidadeDominio> listaProduto;
		
		
		public EntidadeDominio getComputadorCadastro() {
			return computadorCadastro;
		}
		public void setComputadorCadastro(EntidadeDominio computadorCadastro) {
			this.computadorCadastro = computadorCadastro;
		}
		public List<EntidadeDominio> getListaComputadorFiltrados() {
			return listaComputadorFiltrados;
		}
		public void setListaComputadorFiltrados(List<EntidadeDominio> listaComputadorFiltrados) {
			this.listaComputadorFiltrados = listaComputadorFiltrados;
		}
		public List<EntidadeDominio> getListaProduto() {
			return listaProduto;
		}
		public void setListaProduto(List<EntidadeDominio> listaProduto) {
			this.listaProduto = listaProduto;
		}
		public List<EntidadeDominio> getListaComputador() {
			return listaComputador;
		}
		public void setListaComputador(List<EntidadeDominio> listaComputador) {
			this.listaComputador = listaComputador;
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
				ComputadorDAO compdao = new ComputadorDAO();
				listaComputador = compdao.listar();
			} catch (RuntimeException ex) {
				FacesUtil.addMsgError("Erro ao tentar listar os clientes");
			}
		}

		public void carregarCadastro() {
			try {

				if (codigo != null) {
					ComputadorDAO compdao = new ComputadorDAO();
					computadorCadastro = compdao.buscarPorCodigo(codigo);

				} else {
					computadorCadastro = new Computador();
				}
				ProdutoDAO proddao = new ProdutoDAO();
				listaProduto = proddao.listar();
			} catch (RuntimeException ex) {
				FacesUtil.addMsgError("Erro ao tentar obter os dados dos clientes");
			}
		}

		public void novo() {
			computadorCadastro = new Computador();
		}

		public void salvar() {
			try {
				ComputadorDAO compdao = new ComputadorDAO();
				compdao.salvar(computadorCadastro);

				FacesUtil.addMsgInfo("Cliente salvo com Sucesso");

				this.computadorCadastro = new Computador();
			} catch (RuntimeException ex) {
				FacesUtil.addMsgError("Erro ao tentar incluir um Cliente");
			}
		}

		public void excluir() {
			try {
				ComputadorDAO compdao = new ComputadorDAO();
				compdao.excluir(computadorCadastro);

				FacesUtil.addMsgInfo("Cliente removido com Sucesso");

			} catch (RuntimeException ex) {
				FacesUtil.addMsgError("Erro ao tentar remover um Cliente");
			}
		}

		public void editar() {
			try {
				ComputadorDAO compdao = new ComputadorDAO();
				compdao.editar(computadorCadastro);

				FacesUtil.addMsgInfo("Cliente editado com Sucesso");

			} catch (RuntimeException ex) {
				FacesUtil.addMsgError("Erro ao tentar editar um Cliente");
			}
		}

}
