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
import br.com.promove.entidade.Autor;
import br.com.promove.util.HibernateUtil;

@ManagedBean(name = "autorMB")
@ViewScoped
public class AutorMB {

	private Autor autor;
	private List<String> listNomeAutores = new ArrayList<>();
	private List<Autor> listAutores;
	private AutorDAO dao;

	@PostConstruct
	public void init() {
		autor = new Autor();
		dao = new AutorDAO();
		listAutores = dao.listAutor();

		limpar();
	}

	public void limpar() {
		autor = new Autor();
	}

	public void salvar() {
		dao = new AutorDAO();
		if (autor.getIdAutor() != autor.getIdAutor()) {
			dao.atualizar(autor);
			addMessage("Alterado!");
		} else {
			dao.incluir(autor);
			addMessage("Cadastrado!");
		}
		init();
	}

	public void excluir(Autor a) {
		dao.excluir(a);
		init();
	}

	public void recuperarAutor(Autor a) {
		Session sessao = HibernateUtil.getSession();
		sessao.beginTransaction();

		sessao.merge(a);

		sessao.getTransaction().commit();
		sessao.close();
	}

	public List<String> getAutores() {
		try {
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");

			PreparedStatement ps = null;
			ps = connection.prepareStatement("SELECT * FROM autores");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				listNomeAutores.add(rs.getString("nome"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listNomeAutores;
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<String> getListNomeAutores() {
		return listNomeAutores;
	}

	public void setListNomeAutores(List<String> listNomeAutores) {
		this.listNomeAutores = listNomeAutores;
	}

	public List<Autor> getListAutores() {
		return listAutores;
	}

	public void setListAutores(List<Autor> listAutores) {
		this.listAutores = listAutores;
	}

	public AutorDAO getDao() {
		return dao;
	}

	public void setDao(AutorDAO dao) {
		this.dao = dao;
	}

}
