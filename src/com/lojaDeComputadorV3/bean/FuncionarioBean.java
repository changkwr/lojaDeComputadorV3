package com.lojaDeComputadorV3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lojaDeComputadorV3.dao.FuncionarioDAO;
import com.lojaDeComputadorV3.domain.Funcionario;
import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {

    private EntidadeDominio funcionarioCadastro;
	private List<EntidadeDominio> listaFuncionario;
	private List<EntidadeDominio> listaFuncionarioFiltrados;
	private String acao;
	private Long codigo;
	private EntidadeDominio entidade;
	
	
	public EntidadeDominio getFuncionarioCadastro() {
		return funcionarioCadastro;
	}
	public void setFuncionarioCadastro(EntidadeDominio funcionarioCadastro) {
		this.funcionarioCadastro = funcionarioCadastro;
	}
	public List<EntidadeDominio> getListaFuncionario() {
		return listaFuncionario;
	}
	public void setListaFuncionario(List<EntidadeDominio> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}
	public List<EntidadeDominio> getListaFuncionarioFiltrados() {
		return listaFuncionarioFiltrados;
	}
	public void setListaFuncionarioFiltrados(List<EntidadeDominio> listaFuncionarioFiltrados) {
		this.listaFuncionarioFiltrados = listaFuncionarioFiltrados;
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
			FuncionarioDAO clidao = new FuncionarioDAO();
			listaFuncionario = clidao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar listar os funcionarios");
		}
	}

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				FuncionarioDAO clidao = new FuncionarioDAO();
				funcionarioCadastro = clidao.buscarPorCodigo(codigo);

			} else {
				funcionarioCadastro = new Funcionario();
			}
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados dos funcionarios");
		}
	}

	public void novo() {
		funcionarioCadastro = new Funcionario();
	}

	public void salvar() {
		try {
			FuncionarioDAO clidao = new FuncionarioDAO();
			clidao.salvar(funcionarioCadastro);

			FacesUtil.addMsgInfo("Funcionario salvo com Sucesso");

			this.funcionarioCadastro = new Funcionario();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar incluir um Funcionario");
		}
	}

	public void excluir() {
		try {
			FuncionarioDAO clidao = new FuncionarioDAO();
			clidao.excluir(funcionarioCadastro);

			FacesUtil.addMsgInfo("Funcionario removido com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar remover um Funcionario");
		}
	}

	public void editar() {
		try {
			FuncionarioDAO clidao = new FuncionarioDAO();
			clidao.editar(funcionarioCadastro);

			FacesUtil.addMsgInfo("Funcionario editado com Sucesso");

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar editar um Funcionario");
		}
	}
	
	
}
