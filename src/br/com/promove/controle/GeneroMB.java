package br.com.promove.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.Session;

import br.com.promove.dao.AutorDAO;
import br.com.promove.dao.GeneroDAO;
import br.com.promove.entidade.Autor;
import br.com.promove.entidade.Genero;
import br.com.promove.util.HibernateUtil;

@ManagedBean(name = "generoMB")
@ViewScoped
public class GeneroMB {

	private Genero genero;
	private List<String> listNomeGeneros = new ArrayList<>();
	private List<Genero> listGeneros;
	private GeneroDAO dao;

	@PostConstruct
	public void init() {
		genero = new Genero();
		dao = new GeneroDAO();
		listGeneros = dao.listGenero();

		limpar();
	}

	public void limpar() {
		genero = new Genero();
	}

	public void salvar() {
		dao = new GeneroDAO();
		if (genero.getIdGenero() != genero.getIdGenero()) {
			dao.atualizar(genero);
			addMessage("Alterado!");

		} else {
			dao.incluir(genero);
			addMessage("Cadastrado!");
		}
		init();
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void excluir(Genero g) {
		dao.excluir(g);
		init();
	}

	public void recuperarGenero(Genero g) {
		Session sessao = HibernateUtil.getSession();
		sessao.beginTransaction();

		sessao.merge(g);

		sessao.getTransaction().commit();
		sessao.close();
	}

	public List<String> getGeneros() {
		try {
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");

			PreparedStatement ps = null;
			ps = connection.prepareStatement("SELECT * FROM generos");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				listNomeGeneros.add(rs.getString("genero"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listNomeGeneros;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<String> getListNomeGeneros() {
		return listNomeGeneros;
	}

	public void setListNomeGeneros(List<String> listNomeGeneros) {
		this.listNomeGeneros = listNomeGeneros;
	}

	public List<Genero> getListGeneros() {
		return listGeneros;
	}

	public void setListGeneros(List<Genero> listGeneros) {
		this.listGeneros = listGeneros;
	}

	public GeneroDAO getDao() {
		return dao;
	}

	public void setDao(GeneroDAO dao) {
		this.dao = dao;
	}

}
