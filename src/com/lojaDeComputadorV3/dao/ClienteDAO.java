package com.lojaDeComputadorV3.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lojaDeComputadorV3.domain.Cliente;
import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.util.HibernateUtil;

public class ClienteDAO extends AbstractDAO {
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

		List<EntidadeDominio> clientes = null;

		try {
			Query consulta = sessao.getNamedQuery("Cliente.listar");
			clientes = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return clientes;
	}

	@Override
	public EntidadeDominio buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Cliente cliente = null;

		try {
			Query consulta = sessao.getNamedQuery("Cliente.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			cliente = (Cliente) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return cliente;
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
	
	public Cliente autenticar(String email, String senha) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Cliente cliente = null;

		try {
			Query consulta = sessao.getNamedQuery("Cliente.autenticar");
			consulta.setString("email", email);
			consulta.setString("senha", senha);
			cliente = (Cliente) consulta.uniqueResult();
			
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return cliente;
	}
	
	
	
	
}
