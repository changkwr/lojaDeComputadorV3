package com.lojaDeComputadorV3.dao;

import java.util.List;

import com.lojaDeComputadorV3.domain.EntidadeDominio;

public abstract class AbstractDAO implements IDAO {

	@Override
	public void salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
	}

	@Override
	public void editar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<EntidadeDominio> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadeDominio buscarPorCodigo(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}



}
