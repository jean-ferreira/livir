package br.com.promove.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.promove.entidade.Genero;
import br.com.promove.util.HibernateUtil;

public class GeneroDAO extends GenericDaoImpl<Genero>{
	
	public GeneroDAO() {
		super(Genero.class);
	}
	
	public Genero recuperaGenero(int idGenero) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Genero a WHERE a.idGenero = :idGenero");
		
		query.setParameter("idGenero", idGenero);
		Genero genero = (Genero) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return genero;
		} catch (Exception e) {
			return null;
		}
	}	

}
