package br.com.promove.util;


import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.promove.entidade.ItemMenu;
import br.com.promove.entidade.Login;

public class VerificaPermissao {

	ExternalContext ec;
	FacesContext context;

	public List<ItemMenu> buscaMenu(Login login) throws Exception {
		List<ItemMenu> listaMenu = new ArrayList<ItemMenu>();
		ItemMenu menu = new ItemMenu();

		menu = new ItemMenu();
		menu.setCodigoMenu("0010");
		menu.setDescricaoMenu("Livro");
		menu.setAcao("controleLivro");
		//menu.setIcone("ui-icon-note");
		menu.setSubItems(null);
		listaMenu.add(menu);
		
		menu = new ItemMenu();
		menu.setCodigoMenu("0011");
		menu.setDescricaoMenu("Autor");
		menu.setAcao("controleAutor");
		//menu.setIcone("ui-icon-note");
		menu.setSubItems(null);
		listaMenu.add(menu);
		
		menu = new ItemMenu();
		menu.setCodigoMenu("0012");
		menu.setDescricaoMenu("Genêro");
		menu.setAcao("controleGenero");
	//	menu.setIcone("ui-icon-note");
		menu.setSubItems(null);
		listaMenu.add(menu);
		
		menu = new ItemMenu();
		menu.setCodigoMenu("0013");
		menu.setDescricaoMenu("Emprestimo");
		menu.setAcao("controleEmprestimo");
		// menu.setIcone("ui-icon-note");
		menu.setSubItems(null);
		listaMenu.add(menu);
		
		menu = new ItemMenu();
		menu.setCodigoMenu("0014");
		menu.setDescricaoMenu("Renovação");
		menu.setAcao("controleRenovacao");
	//	menu.setIcone("ui-icon-note");
		menu.setSubItems(null);
		
		listaMenu.add(menu);

		return listaMenu;
	}

}