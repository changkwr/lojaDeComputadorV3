package com.lojaDeComputadorV3.test;

import org.junit.Test;

import com.lojaDeComputadorV3.util.HibernateUtil;

public class GerarTabelaTest {

	
	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
	
}
