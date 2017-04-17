package br.com.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.entidades.Carro;
import br.com.entidades.Usuario;
import br.com.service.UsuarioService;
import br.com.util.ListFactory;

@ManagedBean
@ViewScoped
public class CarroBean {

	private Carro carroAdd;

	@Inject
	private UsuarioService usuarioService;

	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;

	@ManagedProperty("#{listFactory}")
	private ListFactory listFactory;

	public String adicionarCarro() {
		Usuario u = getLoginBean().getUsuarioLogado();
		u.getCarros().add(getCarroAdd());
		usuarioService.update(u);
		getLoginBean().setUsuarioLogado(u);
		getLoginBean().atualizarPerguntasUsuarioLogado();
		return "carros";
	}

	public String editarCarro() {
		Usuario u = getLoginBean().getUsuarioLogado();
		u.getCarros().add(getCarroAdd());
		usuarioService.update(u);
		getLoginBean().setUsuarioLogado(u);
		getLoginBean().atualizarPerguntasUsuarioLogado();
		return "carros";
	}

	public String removerCarro(Carro c) {
		Usuario u = getLoginBean().getUsuarioLogado();
		if (u.getCarros().contains(c)) {
			u.getCarros().remove(c);
			usuarioService.update(u);
			getLoginBean().setUsuarioLogado(u);
			getLoginBean().atualizarPerguntasUsuarioLogado();
		}

		return "carros";
	}

	public Carro getCarroAdd() {
		if (carroAdd == null) {
			carroAdd = new Carro();
		}
		return carroAdd;
	}

	public void setCarroAdd(Carro carroAdd) {
		this.carroAdd = carroAdd;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public ListFactory getListFactory() {
		return listFactory;
	}

	public void setListFactory(ListFactory listFactory) {
		this.listFactory = listFactory;
	}

}
