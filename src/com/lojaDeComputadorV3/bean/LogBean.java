package com.lojaDeComputadorV3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lojaDeComputadorV3.dao.ClienteDAO;
import com.lojaDeComputadorV3.dao.LogDAO;
import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.domain.Log;
import com.lojaDeComputadorV3.util.FacesUtil;

@ManagedBean
@ViewScoped
public class LogBean {

	private EntidadeDominio logCadastro;
	private List<EntidadeDominio> listaLog;
	private List<EntidadeDominio> listaLogFiltrados;
	private String acao;
	private Long codigo;
	private EntidadeDominio entidade;
	private List<EntidadeDominio> listaFuncionario;
	
	
	public List<EntidadeDominio> getListaFuncionario() {
		return listaFuncionario;
	}
	public void setListaFuncionario(List<EntidadeDominio> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}
	public EntidadeDominio getLogCadastro() {
		return logCadastro;
	}
	public void setLogCadastro(EntidadeDominio logCadastro) {
		this.logCadastro = logCadastro;
	}
	public List<EntidadeDominio> getListaLog() {
		return listaLog;
	}
	public void setListaLog(List<EntidadeDominio> listaLog) {
		this.listaLog = listaLog;
	}
	public List<EntidadeDominio> getListaLogFiltrados() {
		return listaLogFiltrados;
	}
	public void setListaLogFiltrados(List<EntidadeDominio> listaLogFiltrados) {
		this.listaLogFiltrados = listaLogFiltrados;
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
			LogDAO logdao = new LogDAO();
			listaLog = logdao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar listar os Logs");
		}
	}

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				LogDAO logdao = new LogDAO();
				logCadastro = logdao.buscarPorCodigo(codigo);

			} else {
				logCadastro = new Log();
			}
			ClienteDAO fundao = new ClienteDAO();
			listaFuncionario = fundao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados dos Logs");
		}
	}

	public void novo() {
		logCadastro = new Log();
	}

	public void salvar() {
		try {
			LogDAO logdao = new LogDAO();
			logdao.salvar(logCadastro);

			FacesUtil.addMsgInfo("Logs salvos com Sucesso");

			this.logCadastro = new Log();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar incluir um Log");
		}
	}
	
}
