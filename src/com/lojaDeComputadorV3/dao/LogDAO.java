package com.lojaDeComputadorV3.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.domain.Log;
import com.lojaDeComputadorV3.util.HibernateUtil;

public class LogDAO extends AbstractDAO {
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

		List<EntidadeDominio> logs = null;

		try {
			Query consulta = sessao.getNamedQuery("Log.listar");
			logs = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return logs;
	}

	@Override
	public EntidadeDominio buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Log log = null;

		try {
			Query consulta = sessao.getNamedQuery("Log.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			log = (Log) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return log;
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
}
