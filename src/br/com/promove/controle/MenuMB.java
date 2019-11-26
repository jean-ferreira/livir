package br.com.promove.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.menubar.Menubar;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import br.com.promove.entidade.ItemMenu;
import br.com.promove.entidade.Login;
import br.com.promove.entidade.SubItemMenu;
import br.com.promove.util.Services;
import br.com.promove.util.VerificaPermissao;

@SuppressWarnings("serial")

@ManagedBean
@SessionScoped
public class MenuMB extends BaseMB {

	private MenuModel model;
	private Login login;
	private boolean exibirMenu = false;
	Menubar menubar;

	@PostConstruct
	public void init() {
		usuario = "Nelson";
		login = new Login();

		login.setUsuario("Nelson");

		VerificaPermissao p = new VerificaPermissao();

		try {
			menus = p.buscaMenu(login);
			model = new DefaultMenuModel();
			DefaultSubMenu firstSubmenu = new DefaultSubMenu("Menu");
			DefaultSubMenu secondSubmenu;
			DefaultMenuItem it;

			int qtd = menus.size();
			int contador = 0;
			if (menus != null) {
				for (ItemMenu item : menus) {
					if (contador != qtd) {
						if (item.getSubItems() != null && !item.getSubItems().isEmpty()) {
							secondSubmenu = new DefaultSubMenu(item.getDescricaoMenu(), item.getIcone());
							for (SubItemMenu sub : item.getSubItems()) {
								DefaultMenuItem submenu = new DefaultMenuItem(sub.getDescricaoSubItem());
								submenu.setIcon(sub.getIcone());
								if (sub.getAcao() != null) {
									submenu.setOutcome(sub.getAcao());
									secondSubmenu.addElement(submenu);
								}
							}
							firstSubmenu.addElement(secondSubmenu);
						} else {
							it = new DefaultMenuItem(item.getDescricaoMenu(), item.getIcone());
							if (item.getAcao() != null) {
								it.setOutcome(item.getAcao());
								firstSubmenu.addElement(it);
							}
						}
						contador = contador + 1;
					}
				}
			}
			exibirMenu = true;
			model.addElement(firstSubmenu);
		} catch (Exception e) {
			Services.redirecionarErro("Usuário não autorizado!");

		}
	}

	public Menubar getMenubar() {
		return menubar;
	}

	public void setMenubar(Menubar menubar) {
		this.menubar = menubar;
	}

	private String usuario;
	private String senha;
	private String novaSenha;
	private String autentica;

	// HtmlToolBar menuBar;
	List<ItemMenu> menus;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setAutentica(String autentica) {
		this.autentica = autentica;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public void destroy(String bean) {
		super.destroyAttributeSession(bean);
	}

	public List<ItemMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<ItemMenu> menus) {
		this.menus = menus;
	}

	public MenuModel getModel() {

		return model;
	}

	public boolean isExibirMenu() {
		return exibirMenu;
	}

	public void setExibirMenu(boolean exibirMenu) {
		this.exibirMenu = exibirMenu;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}