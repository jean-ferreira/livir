package br.com.promove.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTORES")
public class Autor {

	public Autor() {
		
	}

	public Autor(String nome) {
		this.nome = nome;
	}

	@Id
	@GeneratedValue
	@Column(name = "id_autor")
	private int idAutor;

	@Column(name = "nome")
	private String nome;

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
