package br.com.promove.controle;


import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.promove.dao.LivroDAO;
import br.com.promove.entidade.Livro;

@ManagedBean
@ViewScoped	
public class LivroMB {
	
	private Livro livro;
	private LivroDAO dao;
	
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
}
