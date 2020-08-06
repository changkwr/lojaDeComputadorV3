package com.lojaDeComputadorV3.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lojaDeComputadorV3.domain.EntidadeDominio;
import com.lojaDeComputadorV3.domain.Telefone;
import com.lojaDeComputadorV3.util.HibernateUtil;

public class TelefoneDAO extends AbstractDAO {
	
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

		List<EntidadeDominio> telefones = null;

		try {
			Query consulta = sessao.getNamedQuery("Telefone.listar");
			telefones = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return telefones;
	}

	@Override
	public EntidadeDominio buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Telefone telefone = null;

		try {
			Query consulta = sessao.getNamedQuery("Telefone.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			telefone = (Telefone) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return telefone;
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
