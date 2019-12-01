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

import br.com.promove.dao.GeneroDAO;
import br.com.promove.entidade.Genero;

@ManagedBean(name = "generoMB")
@ViewScoped
public class GeneroMB {
	
	private Genero genero;
	private List<String> listaGeneros = new ArrayList<>();
	private GeneroDAO dao;	

	@PostConstruct
	public void init() {
		genero = new Genero();
		dao = new GeneroDAO();		
	}
	
	public void salvar(ActionEvent actionEvent) {
		if (genero != null) {
			dao.incluir(genero);
		}
		genero = new Genero();
		addMessage("Cadastrado!");
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<String> getGeneros() {
		try {
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root","");
			
			PreparedStatement ps = null;
			ps = connection.prepareStatement("SELECT * FROM generos");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listaGeneros.add(rs.getString("genero"));				
			}			
		} catch (Exception e) {
			System.out.println(e);
		}
		return listaGeneros;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<String> getListaGeneros() {
		return listaGeneros;
	}

	public void setListaGeneros(List<String> listaGeneros) {
		this.listaGeneros = listaGeneros;
	}

	public GeneroDAO getDao() {
		return dao;
	}

	public void setDao(GeneroDAO dao) {
		this.dao = dao;
	}	

}
