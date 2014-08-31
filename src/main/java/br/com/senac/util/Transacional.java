package br.com.senac.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * <p>
 * <b>Título:</b> Transacional.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Anotação responsável por tratar das transações.
 * </p>
 *
 * Data de criação: 31/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@InterceptorBinding
public @interface Transacional {

}
