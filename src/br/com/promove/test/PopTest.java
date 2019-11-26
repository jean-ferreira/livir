package br.com.promove.test;

import br.com.promove.dao.AutorDAO;
import br.com.promove.dao.GeneroDAO;
import br.com.promove.dao.LivroDAO;
import br.com.promove.entidade.Autor;
import br.com.promove.entidade.Genero;
import br.com.promove.entidade.Livro;

public class PopTest {
	
	public static void main(String[] args) {
		/*
		String[] generos = {"Épico", "Fábula", "Epopeia", "Novela", "Conto", "Crônica", "Ensaio", "Romance"};
		String[] autores = {"J.K. Rowling", "Stephen King", "J. R. R.", "Jane Austen", "Paulo Coelho"};
		
		GeneroDAO generoDAO = new GeneroDAO();
		AutorDAO autorDAO = new AutorDAO();
		
		
		for (int i = 0; i < generos.length; i++) {
			Genero genero = new Genero(generos[i], "DESC");			
			generoDAO.incluir(genero);
		}		
		
		for (int i = 0; i < autores.length; i++) {
			Autor autor = new Autor(autores[i]);
			autorDAO.incluir(autor);
		}		
		
		Autor a = autorDAO.recuperar(1);
		Genero g = generoDAO.recuperaGenero(1);
		
		
		Livro livro = new Livro("Harry Potter", a, g);
		LivroDAO livroDAO = new LivroDAO();
	
		livroDAO.incluir(livro);
		
		
		Genero g = new Genero();
		g.addGeneros();
		System.out.println(g.getGeneros());
		*/
	}
	
}
