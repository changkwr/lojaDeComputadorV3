package com.lojaDeComputadorV3.main;

import com.lojaDeComputadorV3.util.HibernateUtil;

public class GeraTabela {
	
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
	
}
