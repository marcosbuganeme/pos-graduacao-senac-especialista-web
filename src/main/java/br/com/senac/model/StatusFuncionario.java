package br.com.senac.model;

/**
 * <p>
 * <b>Título:</b> StatusFuncionario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Enumerator responsável por representar o status do funcionário no sistema.
 * </p>
 *
 * Data de criação: 31/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public enum StatusFuncionario {

	/** Constante ATIVO. */
	ATIVO("Ativo"),

	/** Constante FERIAS. */
	FERIAS("Em férias"),

	/** Constante INATIVO. */
	INATIVO("Inativo");

	/** Atributo descricao. */
	private String descricao;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param descricao
	 */
	private StatusFuncionario( final String descricao ) {

		this.descricao = descricao;
	}

	/**
	 * Retorna o valor do atributo <code>descricao</code>
	 *
	 * @return <code>String</code>
	 */
	public final String getDescricao() {

		return this.descricao;
	}

}
