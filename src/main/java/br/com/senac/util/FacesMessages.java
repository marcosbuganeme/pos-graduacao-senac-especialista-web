package br.com.senac.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * <p>
 * <b>Título:</b> FacesMessages.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por manipular o objeto FacesMessage do JSF para facilitar a manipulação de mensagens na camada de visão.
 * </p>
 *
 * Data de criação: 31/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class FacesMessages implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Método responsável por adicionar uma mensagem na tela do usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @param message
	 *            - mensagem a ser exibida na tela.
	 * 
	 * @param severity
	 *            - severidade da mensagem.
	 */
	private void add(String message, Severity severity) {

		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage(message);

		msg.setSeverity(severity);

		context.addMessage(null, msg);
	}

	/**
	 * Método responsável por adicionar uma mensagem de informação.
	 *
	 * @author marcosbuganeme
	 *
	 * @param message
	 *            - mensagem a ser exibida na tela.
	 */
	public void info(String message) {

		add(message, FacesMessage.SEVERITY_INFO);
	}

	/**
	 * Método responsável por adicionar uma mensagem de erro.
	 *
	 * @author marcosbuganeme
	 *
	 * @param message
	 *            - mensagem a ser exibida na tela.
	 */
	public void error(String message) {

		add(message, FacesMessage.SEVERITY_ERROR);
	}

}
