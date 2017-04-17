package br.com.managedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.entidades.Usuario;
import br.com.service.UsuarioService;

@ViewScoped
@ManagedBean(name = "manterUsuario")
public class ManterUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuarioAdd;
	private String search;

	@Inject
	private UsuarioService usuarioService;

	public String adicionarUsuario() {

		if (!getUsuarioAdd().getSenha().equals(getUsuarioAdd().getConfirmacaoSenha())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A senha n�o � igual � confirma��o de senha!", ""));
			return "adicionarUsuario.xhtml";
		}

		Usuario userDB = usuarioService.buscarUsuario(getUsuarioAdd().getEmail());

		if (userDB != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "J� existe um registro com esse login ou e-mail!", ""));
			return "adicionarUsuario.xhtml";
		} else {
			getUsuarioAdd().setDataCriado(new Date());
			usuarioService.inserir(getUsuarioAdd());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio registrado com sucesso!", ""));
			setUsuarioAdd(null);
		}

		return "login.xhtml";
	}

	public void criarAdm(Usuario u) {
		usuarioService.update(u);
	}

	public void removerAdm(Usuario u) {
		usuarioService.update(u);
	}

	public List<Usuario> buscaParteNome() {
		return usuarioService.buscarParteNome(this.search);
	}

	public Usuario getUsuarioAdd() {
		if (usuarioAdd == null) {
			usuarioAdd = new Usuario();
		}
		return usuarioAdd;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void setUsuarioAdd(Usuario usuarioAdd) {
		this.usuarioAdd = usuarioAdd;
	}

}
