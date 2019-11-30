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

import br.com.promove.dao.AutorDAO;
import br.com.promove.entidade.Autor;

@ManagedBean(name =  "autorMB")
@ViewScoped
public class AutorMB {

	private Autor autor;
	private List<String> listaAutores = new ArrayList<>();	
	private AutorDAO dao;

	@PostConstruct
	public void init() {
		autor = new Autor();
		dao = new AutorDAO();
	}

	public List<String> getAutores() {
		try {
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root","");
			
			PreparedStatement ps = null;
			ps = connection.prepareStatement("SELECT * FROM autores");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listaAutores.add(rs.getString("nome"));				
			}			
		} catch (Exception e) {
			System.out.println(e);
		}
		return listaAutores;
	}
	
	public void salvar(ActionEvent actionEvent) {
		if (autor != null) {
			dao.incluir(autor);
		}
		autor = new Autor();
		addMessage("Cadastrado!");
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

	public List<String> getListaAutores() {
		return listaAutores;
	}

	public void setListaAutores(List<String> listaAutores) {
		this.listaAutores = listaAutores;
	}

	public AutorDAO getDao() {
		return dao;
	}

	public void setDao(AutorDAO dao) {
		this.dao = dao;
	}	
}
