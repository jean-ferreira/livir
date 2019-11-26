package br.com.promove.entidade;

import java.io.Serializable;

public class SubItemMenu implements Serializable {

	private static final long serialVersionUID = -2411570108005483083L;
	
	private String codigoSubItem;
	private String descricaoSubItem;
	private String acao;
	private String icone;

	public String getCodigoSubItem() {
		return codigoSubItem;
	}

	public void setCodigoSubItem(String codigoSubItem) {
		this.codigoSubItem = codigoSubItem;
	}

	public String getDescricaoSubItem() {
		return descricaoSubItem;
	}

	public void setDescricaoSubItem(String descricaoSubItem) {
		this.descricaoSubItem = descricaoSubItem;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

}