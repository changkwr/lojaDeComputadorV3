package com.lojaDeComputadorV3.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.lojaDeComputadorV3.dao.ClienteDAO;
import com.lojaDeComputadorV3.dao.FuncionarioDAO;
import com.lojaDeComputadorV3.domain.Cliente;
import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.domain.Funcionario;
import com.lojaDeComputadorV3.util.FacesUtil;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {

	private EntidadeDominio clienteLogado;

	public EntidadeDominio getClienteLogado() {
		if (clienteLogado == null) {
			clienteLogado = new Cliente();
		}
		return clienteLogado;
	}

	public void setClienteLogado(EntidadeDominio clienteLogado) {
		this.clienteLogado = clienteLogado;
	}

	private EntidadeDominio funcionarioLogado;

	public EntidadeDominio getFuncionarioLogado() {
		if (funcionarioLogado == null) {
			funcionarioLogado = new Funcionario();
		}
		return funcionarioLogado;
	}

	public void setFuncionarioLogado(EntidadeDominio funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

	public String autenticar() {

		try {
			FuncionarioDAO funDAO = new FuncionarioDAO();
			funcionarioLogado = funDAO.autenticar(((Funcionario) funcionarioLogado).getEmail(),
					(((Funcionario) funcionarioLogado).getSenha()));
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteLogado = clienteDAO.autenticar(((Cliente) clienteLogado).getEmail(),
					(((Cliente) clienteLogado).getSenha()));

			if (clienteLogado == null) {
				FacesUtil.addMsgError("E-mail e/ou Senha inválidos");
				return null;
			} else {
				FacesUtil.addMsgInfo("Cliente autenticado com sucesso");
				return "/pages/principal.xhtml?faces-redirect=true";
			}
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar autenticar no sistema!");
			return null;
		}

	}

	public String autenticarFuncionario() {

		try {
			FuncionarioDAO funDAO = new FuncionarioDAO();
			funcionarioLogado = funDAO.autenticar(((Funcionario) funcionarioLogado).getEmail(),
					(((Funcionario) funcionarioLogado).getSenha()));

			if (funcionarioLogado == null) {
				FacesUtil.addMsgError("E-mail e/ou Senha inválidos");
				return null;
			} else {
				FacesUtil.addMsgInfo("Funcionário autenticado com sucesso");
				return "/pages/principal.xhtml?faces-redirect=true";
			}
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar autenticar no sistema!");
			return null;
		}

	}

	public String sair() {

		clienteLogado = null;

		return "/pages/principal.xhtml?faces-redirect=true";
	}

}
