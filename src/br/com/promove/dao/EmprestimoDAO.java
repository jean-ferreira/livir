package br.com.promove.dao;

import org.hibernate.Query;

import org.hibernate.Session;

import br.com.promove.entidade.Emprestimo;
import br.com.promove.util.HibernateUtil;

public class EmprestimoDAO extends GenericDaoImpl<Emprestimo> {
	
	public EmprestimoDAO() {
		super(Emprestimo.class);
	}
	
	public Emprestimo recuperaEmprestimo(int idEmprestimo) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Emprestimo a WHERE a.idEmprestion = :idEmprestimo");
		
		query.setParameter("idEmprestimo", idEmprestimo);
		Emprestimo emprestimo = (Emprestimo) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return emprestimo;
		} catch(Exception e) {
			return null;
		}
	}
	
	public Emprestimo recuperaEmprestimo(String statusPagamento) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Emprestimo a WHERE a.statusPagamento = :statusPagamento");
		
		query.setParameter("statusPagamento", statusPagamento);
		Emprestimo emprestimo = (Emprestimo) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return emprestimo;
		} catch (Exception e) {
			return null;
		}
	}

}
