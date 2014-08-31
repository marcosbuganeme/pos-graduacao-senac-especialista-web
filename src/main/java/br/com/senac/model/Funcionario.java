package br.com.senac.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

/**
 * <p>
 * <b>Título:</b> Funcionario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar o funcionário no sistema.
 * </p>
 *
 * Data de criação: 31/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	/** Atributo id. */
	private Long id;

	@NotEmpty
	@Column(nullable = false, length = 80)
	/** Atributo nome. */
	private String nome;

	@NotEmpty
	@CPF
	@Column(nullable = false, length = 14)
	/** Atributo cpf. */
	private String cpf;

	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "data_admissao")
	/** Atributo dataAdmissao. */
	private Date dataAdmissao;

	@NotNull
	@DecimalMin("0")
	@Column(precision = 10, scale = 2)
	/** Atributo salario. */
	private BigDecimal salario;

	@NotNull
	@Enumerated(EnumType.STRING)
	/** Atributo status. */
	private StatusFuncionario status;

	/**
	 * Retorna o valor do atributo <code>nome</code>
	 *
	 * @return <code>String</code>
	 */
	public String getNome() {

		return this.nome;
	}

	/**
	 * Define o valor do atributo <code>nome</code>.
	 *
	 * @param nome
	 */
	public void setNome(final String nome) {

		this.nome = nome;
	}

	/**
	 * Retorna o valor do atributo <code>cpf</code>
	 *
	 * @return <code>String</code>
	 */
	public String getCpf() {

		return this.cpf;
	}

	/**
	 * Define o valor do atributo <code>cpf</code>.
	 *
	 * @param cpf
	 */
	public void setCpf(final String cpf) {

		this.cpf = cpf;
	}

	/**
	 * Retorna o valor do atributo <code>dataAdmissao</code>
	 *
	 * @return <code>Date</code>
	 */
	public Date getDataAdmissao() {

		return this.dataAdmissao;
	}

	/**
	 * Define o valor do atributo <code>dataAdmissao</code>.
	 *
	 * @param dataAdmissao
	 */
	public void setDataAdmissao(final Date dataAdmissao) {

		this.dataAdmissao = dataAdmissao;
	}

	/**
	 * Retorna o valor do atributo <code>salario</code>
	 *
	 * @return <code>BigDecimal</code>
	 */
	public BigDecimal getSalario() {

		return this.salario;
	}

	/**
	 * Define o valor do atributo <code>salario</code>.
	 *
	 * @param salario
	 */
	public void setSalario(final BigDecimal salario) {

		this.salario = salario;
	}

	/**
	 * Retorna o valor do atributo <code>status</code>
	 *
	 * @return <code>StatusFuncionario</code>
	 */
	public StatusFuncionario getStatus() {

		return this.status;
	}

	/**
	 * Define o valor do atributo <code>status</code>.
	 *
	 * @param status
	 */
	public void setStatus(final StatusFuncionario status) {

		this.status = status;
	}

	/**
	 * Retorna o valor do atributo <code>id</code>
	 *
	 * @return <code>Long</code>
	 */
	public Long getId() {

		return this.id;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int numeroPrimo = 31;
		int resulto = 1;
		resulto = numeroPrimo * resulto + ( ( this.id == null ) ? 0 : this.id.hashCode() );
		return resulto;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {

			return true;
		}

		if (obj == null) {

			return false;
		}

		if (!( obj instanceof Funcionario )) {

			return false;
		}

		final Funcionario other = (Funcionario) obj;

		if (this.id == null) {

			if (other.id != null) {

				return false;
			}
		} else if (!this.id.equals(other.id)) {

			return false;
		}

		return true;
	}

}
