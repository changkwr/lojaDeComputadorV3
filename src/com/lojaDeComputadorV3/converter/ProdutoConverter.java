package com.lojaDeComputadorV3.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.lojaDeComputadorV3.dao.ProdutoDAO;
import com.lojaDeComputadorV3.domain.Produto;

@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produto = (Produto) produtoDAO.buscarPorCodigo(codigo);
			return produto;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try {
			Produto produto = (Produto) objeto;
			Long codigo = produto.getCodigo();
			return codigo.toString();
		} catch (Exception e) {
			return null;
		}
	}

}
