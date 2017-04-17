package br.com.managedBeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.entidades.rest.MarcaFipe;

@SessionScoped
@ManagedBean(name = "indexBean")
public class IndexBean extends ManagedBeanGenerico {

	private MarcaFipe marca;

	@PostConstruct
	public void init() {
	}

	public MarcaFipe getMarca() {
		if (marca == null) {
			marca = new MarcaFipe();
		}
		return marca;
	}

	public void setMarca(MarcaFipe marca) {
		this.marca = marca;
	}

}
