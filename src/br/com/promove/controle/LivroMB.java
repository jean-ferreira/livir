package br.com.promove.controle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.promove.dao.LivroDAO;
import br.com.promove.entidade.Livro;

@ManagedBean(name = "livroMB")
@RequestScoped
public class LivroMB {

	private Livro livro;
	private LivroDAO dao;

	@PostConstruct
	public void init() {
		livro = new Livro();
		dao = new LivroDAO();
	}

	public void salvar(ActionEvent actionEvent) {
		if (livro != null) {
			dao.incluir(livro);
		}
		livro = new Livro();
		addMessage("Gravado!!");
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LivroDAO getDao() {
		return dao;
	}

	public void setDao(LivroDAO dao) {
		this.dao = dao;
	}

}
