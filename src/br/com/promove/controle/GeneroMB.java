package br.com.promove.controle;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import br.com.promove.dao.GeneroDAO;
import br.com.promove.entidade.Genero;

@ManagedBean
@ViewScoped
public class GeneroMB {
	
	private List<Genero> generos;
	private GeneroDAO dao;

	@PostConstruct
	public void init() {
		generos = dao.recuperarTodos();
	}
	
	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

}
