package com.lojaDeComputadorV3.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.domain.Funcionario;
import com.lojaDeComputadorV3.util.HibernateUtil;

public class FuncionarioDAO extends AbstractDAO{

	@Override
	public void salvar(EntidadeDominio entidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntidadeDominio> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<EntidadeDominio> funcionarios = null;

		try {
			Query consulta = sessao.getNamedQuery("Funcionario.listar");
			funcionarios = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return funcionarios;
	}

	@Override
	public EntidadeDominio buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Funcionario funcionario = null;

		try {
			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			funcionario = (Funcionario) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return funcionario;
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

	@Override
	public void editar(EntidadeDominio entidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.update(entidade);

			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	public Funcionario autenticar(String email, String senha) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Funcionario funcionario = null;

		try {
			Query consulta = sessao.getNamedQuery("Funcionario.autenticar");
			consulta.setString("email", email);
			consulta.setString("senha", senha);
			funcionario = (Funcionario) consulta.uniqueResult();
			
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return funcionario;
	}
	
}
