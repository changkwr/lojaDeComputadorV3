package com.lojaDeComputadorV3.util;

import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.lojaDeComputadorV3.bean.AutenticacaoBean;
import com.lojaDeComputadorV3.domain.Funcionario;

@SuppressWarnings("serial")
public class AutenticacaoPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		UIViewRoot uiViewRoot = facesContext.getViewRoot();
		String paginaAtual = uiViewRoot.getViewId();
		
		boolean ehPaginaAutenticacao = paginaAtual.contains("autenticacao.xhtml");
		
		if(!ehPaginaAutenticacao) {
			ExternalContext externalContext = facesContext.getExternalContext();
			Map<String, Object> mapa = externalContext.getSessionMap();
			AutenticacaoBean autenticacaoBean = (AutenticacaoBean)mapa.get("autenticacaoBean");
			
			Funcionario funcionario =  (Funcionario) autenticacaoBean.getClienteLogado();
			
			if(funcionario.getEhFuncionario() == "False") {
				FacesUtil.addMsgError("Funcionário não autenticado!");
				
				Application application =  facesContext.getApplication();
				NavigationHandler navigationHandler = application.getNavigationHandler();
				navigationHandler.handleNavigation(facesContext, null, "/pages/autenticacao.xhtml?faces-redirect=true");
			}
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
