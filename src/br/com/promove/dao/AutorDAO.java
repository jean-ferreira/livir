package br.com.promove.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.promove.entidade.Autor;
import br.com.promove.util.HibernateUtil;

public class AutorDAO extends GenericDaoImpl<Autor>{
	
	public AutorDAO() {
		super(Autor.class);
	}
	
	public List<Autor> listAutor() {
		Session session = HibernateUtil.getSession();
		
		List<Autor> listAutores = session.createQuery("FROM Autor a").list();
		session.close();
		return listAutores;		
	}
	
	public Autor recuperarAutor(int idAutor) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Autor a WHERE a.idAutor = :idAutor");
		
		query.setParameter("idAutor", idAutor);
		Autor autor = (Autor) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return autor;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Autor recuperarAutor(String nome) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Autor a WHERE a.nome = :nome");
		
		query.setParameter("nome", nome);
		Autor autor = (Autor) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return autor;
		} catch (Exception e) {
			return null;
		}
	}

}
