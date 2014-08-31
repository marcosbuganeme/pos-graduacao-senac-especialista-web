package br.com.senac.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * <p>
 * <b>Título:</b> EntityManagerProducer.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover a fábrica de instâncias JPA.
 * </p>
 *
 * Data de criação: 31/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@ApplicationScoped
public class EntityManagerProducer {

	/** Atributo factory. */
	private EntityManagerFactory factory;

	/** Constante NOME_UNIDADE_PERSISTENCIA. */
	private static final String NOME_UNIDADE_PERSISTENCIA = "senacPU";

	/**
	 * Construtor
	 * 
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public EntityManagerProducer() {

		this.factory = Persistence.createEntityManagerFactory(EntityManagerProducer.NOME_UNIDADE_PERSISTENCIA);
	}

	/**
	 * Método responsável por criar novas instâncias do entityManager.
	 *
	 * @author marcosbuganeme
	 *
	 * @author leides
	 *
	 * @return <i>instanância do entityManager</i>
	 */
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {

		return this.factory.createEntityManager();
	}

	/**
	 * Método responsável por fechar as transações JPA.
	 *
	 * @author marcosbuganeme
	 *
	 * @author leides
	 *
	 * @param manager
	 */
	public void closeEntityManager(@Disposes EntityManager manager) {

		manager.close();
	}

}
