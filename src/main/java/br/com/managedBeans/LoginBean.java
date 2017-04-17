package br.com.managedBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.entidades.Usuario;
import br.com.service.PerguntaService;
import br.com.service.UsuarioService;

@ManagedBean(name = "loginBean")
@SessionScoped 
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuarioLogado;
	private boolean logado = false;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private PerguntaService perguntaService;

	public String login() {
		Usuario user = usuarioService.logarUsuario(getUsuarioLogado().getEmail(), getUsuarioLogado().getSenha());
		if (user != null) {
			setUsuarioLogado(user);
			setLogado(true);
			getUsuarioLogado().setPerguntas(perguntaService.getPerguntas(getUsuarioLogado()));
			return "carros";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usu�rio n�o registrado ou n�o autorizado!", ""));
		}
		return "login";
	}

	public void atualizarPerguntasUsuarioLogado() {
		getUsuarioLogado().setPerguntas(perguntaService.getPerguntas(getUsuarioLogado()));
	}
	
	public String logout() {
		setUsuarioLogado(null);
		setLogado(false);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "login";
	}

	public String isLoggedForward() {
		if (!isLogado()) {
			return "login.xhtml?faces-redirect=true";
		}

		return null;
	}

	public String isLoggedForwardLogin() {
		if (!isLogado()) {
			return null;
		}
		return "home.xhtml";
	}

	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null) {
			usuarioLogado = new Usuario();
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

}
