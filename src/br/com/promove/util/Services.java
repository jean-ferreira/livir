package br.com.promove.util;

import java.io.IOException;

import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.promove.entidade.Login;

public class Services {

	public static String mensagem;

	public static Login login() {
		return (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login");
	}

	public static String usuario() {
		return (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
	}

	public static String parametro(String param) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
			return req.getParameter(param);
		} catch (Exception e) {
			System.out.println("Erro ao recuperar parâmetro:");
			e.printStackTrace();
		}
		return null;
	}

	public static String redirecionarErro(String mensagemOrigem) {
		FacesContext context = FacesContext.getCurrentInstance();
		NavigationHandler navHandler = context.getApplication().getNavigationHandler();
		mensagem = mensagemOrigem;
		navHandler.handleNavigation(context, null, "error");
		return null;
	}

	public static void redirectMenu(String page) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();

		HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();

		String url = req.getRequestURL().toString();
		String vetor[] = url.split("pages");

		try {
			if (!ec.isResponseCommitted()) {
				ec.redirect(vetor[0] + "pages/error.xhtml");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void redirectPrincipal(String page) {

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();

		HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();

		String url = req.getRequestURL().toString();
		String vetor[] = url.split("pages");

		try {
			if (!ec.isResponseCommitted()) {
				ec.redirect(vetor[0] + "pages/" + page + ".xhtml");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * try{ System.out.println(ec.getRequestContextPath() + "/" + page);
		 * ec.redirect(ec.getRequestContextPath() + "/" + page); } catch
		 * (IOException ex) { System.out.println(ex); }
		 */
	}

	public static void redirect(String page) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();

		try {
			ec.redirect(ec.getRequestContextPath() + "/pages/" + page + ".xhtml");
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public static String preencheZeroAntes(String variavel, int tamanho) {
		if (variavel == null) {
			variavel = "";
		}
		while (variavel.length() < tamanho) {
			variavel = "0" + variavel;
		}
		return variavel;
	}

	public static String preencheZeroDepois(String variavel, int tamanho) {
		if (variavel == null) {
			variavel = "";
		}
		while (variavel.length() < tamanho) {
			variavel = variavel + "0";
		}
		return variavel;
	}

	public static String preencheEspacoAntes(String variavel, int tamanho) {
		if (variavel == null) {
			variavel = "";
		}
		while (variavel.length() < tamanho) {
			variavel = " " + variavel;
		}
		return variavel;
	}

	public static String preencheEspacoDepois(String variavel, int tamanho) {
		if (variavel == null) {
			variavel = "";
		}
		while (variavel.length() < tamanho) {
			variavel = variavel + " ";
		}
		return variavel;
	}

	public static Boolean validarCPF(String cpf) {
		if (cpf != null) {
			String cpfAux = cpf.replaceAll("[^0-9]", "");

			if (cpfAux.replaceAll("[^0-9]", "").trim().isEmpty()) {
				Messages.error("Preencha o campo CPF");
				return false;
			}

			if (cpfAux.replaceAll("[^0-9]", "").trim().length() != 11) {
				Messages.error("CPF deve possuir 11 dígitos");
				return false;
			}

			// //////////
			if (cpfAux.equals("00000000000") || cpfAux.equals("11111111111") || cpfAux.equals("22222222222")
					|| cpfAux.equals("33333333333") || cpfAux.equals("44444444444") || cpfAux.equals("55555555555")
					|| cpfAux.equals("66666666666") || cpfAux.equals("77777777777") || cpfAux.equals("88888888888")
					|| cpfAux.equals("99999999999")) {
				Messages.error("CPF inválido");

				return false;
			}
			char dig10, dig11;
			int sm, i, r, num, peso;

			try {
				// Calculo do 1o. Digito Verificador
				sm = 0;
				peso = 10;
				for (i = 0; i < 9; i++) {
					// converte o i-esimo caractere do CPF em um numero:
					// por exemplo, transforma o caractere '0' no inteiro 0
					// (48 eh a posicao de '0' na tabela ASCII)
					num = (int) (cpfAux.charAt(i) - 48);
					sm = sm + (num * peso);
					peso = peso - 1;
				}
				r = 11 - (sm % 11);
				if ((r == 10) || (r == 11)) {
					dig10 = '0';
				} else {
					dig10 = (char) (r + 48);
				}
				// converte no respectivo caractere numerico
				// Calculo do 2o. Digito Verificador
				sm = 0;
				peso = 11;
				for (i = 0; i < 10; i++) {
					num = (int) (cpfAux.charAt(i) - 48);
					sm = sm + (num * peso);
					peso = peso - 1;
				}
				r = 11 - (sm % 11);

				if ((r == 10) || (r == 11)) {
					dig11 = '0';
				} else {
					dig11 = (char) (r + 48);
				}
				// Verifica se os digitos calculados conferem com os digitos
				// informados.
				if ((dig10 == cpfAux.charAt(9)) && (dig11 == cpfAux.charAt(10))) {
					return (true);
				} else {
					Messages.error("Dígito verificador inválido");
					return (false);
				}
			} catch (Exception e) {
				return (false);
			}
		}
		return false;
	}

}
