package br.com.senac.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.senac.model.Funcionario;
import br.com.senac.model.StatusFuncionario;
import br.com.senac.repository.FuncionarioDAO;
import br.com.senac.util.FacesMessages;
import br.com.senac.util.Transacional;

/**
 * <p>
 * <b>Título:</b> GestaoFuncionariosBean.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por gerenciar a tela de CRUD de funcionários.
 * </p>
 *
 * Data de criação: 31/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Named
@ViewScoped
public class GestaoFuncionariosBean implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Inject
	/** Atributo funcionarios. */
	private FuncionarioDAO funcionarios;

	@Inject
	/** Atributo messages. */
	private FacesMessages messages;

	/** Atributo todosFuncionarios. */
	private List<Funcionario> todosFuncionarios;

	/** Atributo funcionarioEdicao. */
	private Funcionario funcionarioEdicao;

	public GestaoFuncionariosBean() {

		this.funcionarioEdicao = new Funcionario();
	}

	/**
	 * Método responsável por realizar uma consulta de todos os funcionários da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @author leides
	 *
	 */
	public void consultar() {

		this.todosFuncionarios = this.funcionarios.todos();
	}

	/**
	 * Método responsável por excluir um funcionário da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @author leides
	 *
	 * @param funcionario
	 */
	@Transacional
	public void excluir(final Funcionario funcionario) {

		this.funcionarios.remover(funcionario);
		this.consultar();

		this.messages.info("Funcionário excluído com sucesso!");
	}

	/**
	 * Método responsável por inserir um usuário na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @author leides
	 *
	 */
	@Transacional
	public void salvar() {

		this.funcionarios.mesclar(this.funcionarioEdicao);

		this.funcionarioEdicao = new Funcionario();

		this.consultar();

		this.messages.info("Funcionário salvo com sucesso!");
	}

	public StatusFuncionario[] getStatuses() {

		return StatusFuncionario.values();
	}

	/**
	 * Retorna o valor do atributo <code>funcionarioEdicao</code>
	 *
	 * @return <code>Funcionario</code>
	 */
	public Funcionario getFuncionarioEdicao() {

		return funcionarioEdicao;
	}

	/**
	 * Define o valor do atributo <code>funcionarioEdicao</code>.
	 *
	 * @param funcionarioEdicao
	 */
	public void setFuncionarioEdicao(Funcionario funcionarioEdicao) {

		this.funcionarioEdicao = funcionarioEdicao;
	}

	/**
	 * Retorna o valor do atributo <code>todosFuncionarios</code>
	 *
	 * @return <code>List<Funcionario></code>
	 */
	public List<Funcionario> getTodosFuncionarios() {

		return todosFuncionarios;
	}

}
