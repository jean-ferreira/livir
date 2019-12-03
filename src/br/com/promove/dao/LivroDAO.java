package br.com.promove.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.promove.entidade.Autor;
import br.com.promove.entidade.Genero;
import br.com.promove.entidade.Livro;
import br.com.promove.util.HibernateUtil;

public class LivroDAO extends GenericDaoImpl<Livro> {
	
	public LivroDAO() {
		super(Livro.class);		
	}
	
	public List<Livro> listLivro() {
		Session session = HibernateUtil.getSession();
		
		List<Livro> listLivros = session.createQuery("FROM Livro l").list();
		session.close();
		return listLivros;		
	}
	
	public Livro recuperaAutor(int idAutor) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Livro a WHERE a.idAutor = :idAutor");
		
		query.setParameter("idAutor", idAutor);
		Livro livro = (Livro) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return livro;
		} catch(Exception e) {
			return null;
		}
	}
	
	public Livro recuperaGenero(Genero genero) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Livro a WHERE a.idGenero = :idGenero");
		
		query.setParameter("idGenero", genero);
		Livro livro = (Livro) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return livro;
		} catch(Exception e) {
			return null;
		}
		
	}

}
