package br.com.promove.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIVROS")
public class Livro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Livro() {

	}

	public Livro(String titulo, Autor autor, Genero genero) {
		this.titulo = titulo;
		setAutor(autor);
		setGenero(genero);
	}

	public Livro(String titulo, Autor autor, Genero genero, int registro, int paginas, String situacao) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.numeroRegistro = registro;
		this.numeroPaginas = paginas;
		this.situacao = situacao;
	}
	

	@Id
	@GeneratedValue
	@Column(name = "id_livro")
	private int idLivro;

	@Column(name = "titulo")
	private String titulo;

	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "id_genero")
	private Genero genero;

	@Column(name = "numero_registro")
	private int numeroRegistro;

	@Column(name = "numero_paginas")
	private int numeroPaginas;

	@Column(name = "situacao")
	private String situacao;

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
