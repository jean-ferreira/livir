package br.com.promove.controle;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import br.com.promove.entidade.Login;
import br.com.promove.util.Services;

public class BaseMB extends HttpServlet {

	private static final long serialVersionUID = 1504258513859458263L;

	private Date dataSistema;
	private Login login;

	public BaseMB() {
	}

	public void destroyAttributeSession(String attribute) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.removeAttribute(attribute);
	}

	public Date getDataSistema() {
		this.dataSistema = new Date();
		return dataSistema;
	}

	public void setDataSistema(Date dataSistema) {
		this.dataSistema = dataSistema;
	}

	public Login getLogin() {
		if (login == null) {
			login = Services.login();
		}
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
