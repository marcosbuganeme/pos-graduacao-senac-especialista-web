package br.com.senac.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.senac.model.Funcionario;

/**
 * <p>
 * <b>Título:</b> FuncionarioDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar o repositório para persistência e consulta de dados do Funcionário.
 * </p>
 *
 * Data de criação: 31/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class FuncionarioDAO implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Inject
	/** Atributo manager. */
	private EntityManager manager;

	/**
	 * Método responsável por buscar um funcionário por um determinado ID.
	 *
	 * @author marcosbuganeme
	 *
	 * @param id
	 *            - identificador pesquisado.
	 * 
	 * @return <i>registro do funcionário</i>.
	 */
	public Funcionario obterPorId(final Long id) {

		return this.manager.find(Funcionario.class, id);
	}

	/**
	 * Método responsável por pesquisar por todos os funcionários cadastrados no sistema.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de funcionários</i>
	 */
	public List<Funcionario> todos() {

		return this.manager.createQuery("from Funcionario", Funcionario.class).getResultList();
	}

	/**
	 * Método responsável por mesclar/alterar um funcionário no sistema.
	 *
	 * @author marcosbuganeme
	 *
	 * @param funcionario
	 *            - que será alterado/mesclado.
	 * 
	 * @return <i>funcionário</i>.
	 */
	public Funcionario mesclar(final Funcionario funcionario) {

		return this.manager.merge(funcionario);
	}

	/**
	 * Método responsável por remover um funcionário no sistema.
	 *
	 * @author marcosbuganeme
	 *
	 * @param funcionario
	 *            - funcionário que será removido.
	 */
	public void remover(Funcionario funcionario) {

		funcionario = this.obterPorId(funcionario.getId());

		this.manager.remove(funcionario);
	}

}
