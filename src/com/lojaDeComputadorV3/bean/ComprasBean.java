package com.lojaDeComputadorV3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lojaDeComputadorV3.dao.ClienteDAO;
import com.lojaDeComputadorV3.dao.ComprasDAO;
import com.lojaDeComputadorV3.dao.ComputadorDAO;
import com.lojaDeComputadorV3.domain.Compras;
import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ComprasBean {

    private EntidadeDominio comprasCadastro;
	private List<EntidadeDominio> listaCompras;
	private List<EntidadeDominio> listaComprasFiltrados;
	private String acao;
	private Long codigo;
	private EntidadeDominio entidade;
	private List<EntidadeDominio> listaComputador;
	private List<EntidadeDominio> listaCliente;
	

	public List<EntidadeDominio> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(List<EntidadeDominio> listaCliente) {
		this.listaCliente = listaCliente;
	}
	public EntidadeDominio getComprasCadastro() {
		return comprasCadastro;
	}
	public void setComprasCadastro(EntidadeDominio comprasCadastro) {
		this.comprasCadastro = comprasCadastro;
	}
	public List<EntidadeDominio> getListaCompras() {
		return listaCompras;
	}
	public void setListaCompras(List<EntidadeDominio> listaCompras) {
		this.listaCompras = listaCompras;
	}
	public List<EntidadeDominio> getListaComprasFiltrados() {
		return listaComprasFiltrados;
	}
	public void setListaComprasFiltrados(List<EntidadeDominio> listaComprasFiltrados) {
		this.listaComprasFiltrados = listaComprasFiltrados;
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
			ComprasDAO comdao = new ComprasDAO();
			listaCompras = comdao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar listar os clientes");
		}
	}

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				ComprasDAO comdao = new ComprasDAO();
				comprasCadastro = comdao.buscarPorCodigo(codigo);

			} else {
				comprasCadastro = new Compras();
			}
			ComputadorDAO compdao = new ComputadorDAO();
			listaComputador = compdao.listar();
			ClienteDAO clidao = new ClienteDAO();
			listaCliente = clidao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados dos clientes");
		}
	}

	public void novo() {
		comprasCadastro = new Compras();
	}

	public void salvar() {
		try {
			ComprasDAO comdao = new ComprasDAO();
			comdao.salvar(comprasCadastro);

			FacesUtil.addMsgInfo("Cliente salvo com Sucesso");

			this.comprasCadastro = new Compras();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar incluir um Cliente");
		}
	}

	public void excluir() {
		try {
			ComprasDAO comdao = new ComprasDAO();
			comdao.excluir(comprasCadastro);

			FacesUtil.addMsgInfo("Cliente removido com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar remover um Cliente");
		}
	}

	public void editar() {
		try {
			ComprasDAO comdao = new ComprasDAO();
			comdao.editar(comprasCadastro);

			FacesUtil.addMsgInfo("Cliente editado com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar editar um Cliente");
		}
	}
}
