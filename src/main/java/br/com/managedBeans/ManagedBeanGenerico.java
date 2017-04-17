package br.com.managedBeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.entidades.Marca;
import br.com.enumeradores.EnumCategoria;
import br.com.enumeradores.EnumEstados;
import br.com.util.ListFactory;

@ManagedBean(name="mbgen")
@ApplicationScoped
public class ManagedBeanGenerico {

	@ManagedProperty("#{listFactory}")
	private ListFactory listFactory;

	public char getMarcaGroup(Marca marca) {
		return marca.getNome().charAt(0);
	}

	public char getEstadoGroup(EnumEstados est) {
		return est.getNome().charAt(0);
	}

	public List<EnumEstados> completeEstado(String query) {
		List<EnumEstados> allEstado = Arrays.asList(EnumEstados.values());
		List<EnumEstados> filteredEstados = new ArrayList<EnumEstados>();

		for (EnumEstados est : allEstado) {
			if (est.getNome().toLowerCase().startsWith(query.toLowerCase())
					|| est.getSigla().toLowerCase().startsWith(query.toLowerCase())) {
				filteredEstados.add(est);
			}
		}

		return filteredEstados;
	}

	public List<EnumCategoria> completeCategoria(String query) {
		List<EnumCategoria> allCategoria = Arrays.asList(EnumCategoria.values());
		List<EnumCategoria> filteredCategoria = new ArrayList<EnumCategoria>();

		for (EnumCategoria cat : allCategoria) {
			if (cat.getNome().toLowerCase().startsWith(query.toLowerCase())) {
				filteredCategoria.add(cat);
			}
		}

		return filteredCategoria;
	}

	public List<Marca> completeMarca(String query) {
		List<Marca> allMarcas = getListFactory().getListaMarca();
		List<Marca> filteredMarcas = new ArrayList<Marca>();

		for (Marca marca : allMarcas) {
			if (marca.getNome().toLowerCase().startsWith(query.toLowerCase())) {
				filteredMarcas.add(marca);
			}
		}

		return filteredMarcas;
	}

	public ListFactory getListFactory() {
		return listFactory;
	}

	public void setListFactory(ListFactory listFactory) {
		this.listFactory = listFactory;
	}

}
