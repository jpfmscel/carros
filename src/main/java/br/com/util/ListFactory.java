package br.com.util;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.entidades.Marca;
import br.com.entidades.rest.MarcaFipe;
import br.com.service.MarcaService;
import br.com.service.VeiculoFipeService;

@ApplicationScoped
@ManagedBean
public class ListFactory {

	@Inject
	private MarcaService marcaService;

	@Inject
	private VeiculoFipeService veiculoFipeService;

	private List<Marca> listaMarca;

	@PostConstruct
	protected void init() {
		listaMarca = marcaService.findAll();
		if (listaMarca.isEmpty()) {
			for (MarcaFipe marca : veiculoFipeService.getMarcas()) {
				marcaService.inserir(new Marca(marca));
			}
			listaMarca = marcaService.findAll();
		}
	}

	public List<Marca> getListaMarca() {
		return listaMarca;
	}

	public void setListaMarca(List<Marca> listaMarca) {
		this.listaMarca = listaMarca;
	}

}
