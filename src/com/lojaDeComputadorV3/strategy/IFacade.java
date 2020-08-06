package com.lojaDeComputadorV3.strategy;

import java.util.List;

import com.lojaDeComputadorV3.domain.EntidadeDominio;


public interface IFacade {

    public String salvar(EntidadeDominio entidade);

    public String editar(EntidadeDominio entidade);

    public String excluir(EntidadeDominio entidade);

    public List<EntidadeDominio> listar();
    
	public EntidadeDominio buscarPorCodigo(EntidadeDominio entidade);


}
