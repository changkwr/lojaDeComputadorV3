package com.lojaDeComputadorV3.dao;

import java.util.List;

import com.lojaDeComputadorV3.domain.EntidadeDominio;


public interface IDAO {

	public void salvar(EntidadeDominio entidade);

    public void editar(EntidadeDominio entidade);

    public void excluir(EntidadeDominio entidade);

    public List<EntidadeDominio> listar();
    
	public EntidadeDominio buscarPorCodigo(Long codigo);

}
