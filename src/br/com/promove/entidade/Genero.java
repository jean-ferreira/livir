package br.com.promove.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "GENEROS")
public class Genero {

	public Genero() {

	}

	public Genero(String genero, String descricao) {
		this.genero = genero;
		this.descricao = descricao;
	}

	@Id
	@GeneratedValue
	@Column(name = "id_genero")
	private int idGenero;

	/*
	@Transient
	private List<Genero> generos;
	*/

	@Column(name = "genero")
	private String genero;

	@Column(name = "descricao")
	private String descricao;

	/*
	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	*/

	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
