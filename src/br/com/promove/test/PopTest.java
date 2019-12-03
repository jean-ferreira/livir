package br.com.promove.test;

import br.com.promove.dao.AutorDAO;
import br.com.promove.dao.GeneroDAO;
import br.com.promove.dao.LivroDAO;
import br.com.promove.entidade.Autor;
import br.com.promove.entidade.Genero;
import br.com.promove.entidade.Livro;

public class PopTest {
	
	public static void main(String[] args) {
		
		String[] generos = {"Épico", "Fábula", "Epopeia", "Novela", "Conto", "Crônica", "Ensaio", "Romance"};
		String[] autores = {"J.K. Rowling", "Stephen King", "J. R. R.", "Jane Austen", "Paulo Coelho", "George R. R. Martins"};
		
		GeneroDAO generoDAO = new GeneroDAO();
		AutorDAO autorDAO = new AutorDAO();
		
		/*
		for (int i = 0; i < generos.length; i++) {
			Genero genero = new Genero(generos[i], "DESC");			
			generoDAO.incluir(genero);
		}		
		
		for (int i = 0; i < autores.length; i++) {
			Autor autor = new Autor(autores[i]);
			autorDAO.incluir(autor);
		}		
		*/
		Autor a = autorDAO.recuperar(1);
		Genero g = generoDAO.recuperaGenero(1);		
		Livro livro = new Livro("Harry Potter", a, g);
		LivroDAO livroDAO = new LivroDAO();	
		livroDAO.incluir(livro);
		
		
		Autor a2 = autorDAO.recuperar(2);
		Genero g2 = generoDAO.recuperaGenero(2);		
		Livro livro2 = new Livro("Senhor dos Aneis", a2, g2);
		LivroDAO livroDAO2 = new LivroDAO();		
		livroDAO.incluir(livro);
		
		Autor a3 = autorDAO.recuperar(6);
		Genero g3 = generoDAO.recuperaGenero(6);		
		Livro livro3 = new Livro("Game of Thrones", a3, g3);
		LivroDAO livroDAO3 = new LivroDAO();		
		livroDAO.incluir(livro3);
		
		/*
		Genero g = new Genero();
		g.addGeneros();
		System.out.println(g.getGeneros());
		*/
	}
	
}
