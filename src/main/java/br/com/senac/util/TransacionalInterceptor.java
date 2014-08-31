package br.com.senac.util;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * <p>
 * <b>Título:</b> TransacionalInterceptor.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por interceptar uma transação.
 * </p>
 *
 * Data de criação: 31/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION + 1)
public class TransacionalInterceptor implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo manager. */
	@Inject
	private EntityManager manager;

	/**
	 * Método responsável por interceptar uma transação e realizar seu devido tratamento.
	 *
	 * @author marcosbuganeme
	 *
	 * @param context
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {

		EntityTransaction transacao = manager.getTransaction();

		boolean criador = false;

		try {

			if (!transacao.isActive()) {

				transacao.begin();

				transacao.rollback();

				transacao.begin();

				criador = true;
			}

			return context.proceed();

		} catch (Exception e) {

			if (transacao != null && criador) {

				transacao.rollback();
			}

			throw e;

		} finally {

			if (transacao != null && transacao.isActive() && criador) {

				transacao.commit();
			}
		}
	}

}
