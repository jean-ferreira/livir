package br.com.promove.entidade;

import java.io.Serializable;
import java.util.List;

public class ItemMenu implements Serializable, Comparable<ItemMenu> {

	private static final long serialVersionUID = 3777290831090586917L;
	
	private String codigoMenu;
	private String descricaoMenu;
	private List<SubItemMenu> subItems;
	private String acao;
	private String icone;

	public String getCodigoMenu() {
		return codigoMenu;
	}

	public void setCodigoMenu(String codigoMenu) {
		this.codigoMenu = codigoMenu;
	}

	public String getDescricaoMenu() {
		return descricaoMenu;
	}

	public void setDescricaoMenu(String descricaoMenu) {
		this.descricaoMenu = descricaoMenu;
	}

	public List<SubItemMenu> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<SubItemMenu> subItems) {
		this.subItems = subItems;
	}

	public int compareTo(ItemMenu o) {
		String obCodigoMenu = o.getCodigoMenu();
		String codigoAux = this.getCodigoMenu();
		return codigoAux.compareTo(obCodigoMenu);
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
