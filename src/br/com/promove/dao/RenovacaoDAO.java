package br.com.promove.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.promove.entidade.Renovacao;
import br.com.promove.util.HibernateUtil;

public class RenovacaoDAO extends GenericDaoImpl<Renovacao> {
	
	public RenovacaoDAO(){
		super(Renovacao.class);
	}
	
	public Renovacao recuperaRenovacao(int idRenovacao) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Renovacao a WHERE a.idRenovacao = :idRenovacao");
		
		query.setParameter("idRenovacao", idRenovacao);
		Renovacao renovacao = (Renovacao) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return renovacao;
		} catch (Exception e) {
			return null;
		}
	}

}
