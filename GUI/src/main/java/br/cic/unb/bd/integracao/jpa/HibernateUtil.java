package br.cic.unb.bd.integracao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que cria o EntityManager para ser usado pelas 
 * Entities de persistencia do Banco de Dados; Economiza
 * escrita de código
 * @author Davi
 *
 */
public class HibernateUtil {

	private HibernateUtil() {	}

	private static HibernateUtil instance;

	public static HibernateUtil instance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}

	public EntityManager em() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("DiariasDB");
		return factory.createEntityManager();
	}
}