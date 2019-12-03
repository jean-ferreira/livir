package br.com.promove.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.Session;

import br.com.promove.dao.LivroDAO;
import br.com.promove.entidade.Autor;
import br.com.promove.entidade.Livro;
import br.com.promove.util.HibernateUtil;

@ManagedBean(name = "livroMB")
@RequestScoped
public class LivroMB {

	private Livro livro;
	private LivroDAO dao;
	private List<Livro> listLivros;

	@PostConstruct
	public void init() {
		livro = new Livro();
		dao = new LivroDAO();
		listLivros = dao.listLivro();

		limpar();
	}

	public void limpar() {
		livro = new Livro();
	}

	public void salvar() {
		dao = new LivroDAO();
		if (livro.getIdLivro() == livro.getIdLivro()) {
			dao.atualizar(livro);
			addMessage("Alterado!");
		} else {
			dao.incluir(livro);
			addMessage("Cadastrado!");
		}
		init();
	}

	public void excluir(Livro l) {
		dao.excluir(l);
		init();
	}

	public void recuperarLivro(Livro l) {
		Session sessao = HibernateUtil.getSession();
		sessao.beginTransaction();

		sessao.merge(l);

		sessao.getTransaction().commit();
		sessao.close();
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

	public List<Livro> getListLivros() {
		return listLivros;
	}

	public void setListLivros(List<Livro> listLivros) {
		this.listLivros = listLivros;
	}

}
