package br.com.promove.entidade;

import java.io.Serializable;

public class Login implements Serializable {

	private static final long serialVersionUID = 4113979875336869969L;

	private String usuario;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}