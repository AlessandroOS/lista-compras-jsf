package br.com.listacompras.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("listaComprasPU");
	
	public static EntityManager getEntityManeger() {
		return factory.createEntityManager();
	}
}
