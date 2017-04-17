package br.com.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.entidades.Marca;
import br.com.util.ListFactory;

@ManagedBean
@RequestScoped
public class MarcaConverter implements Converter {

	@ManagedProperty("#{listFactory}")
	private ListFactory listFactory;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String marcaName) {
		for (Marca m : getListFactory().getListaMarca()) {
			if (m.getNome().toUpperCase().equalsIgnoreCase(marcaName)) {
				return m;
			}
		}
		return "";
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object marca) {
		return ((Marca) marca).getNome();
	}

	public ListFactory getListFactory() {
		return listFactory;
	}

	public void setListFactory(ListFactory listFactory) {
		this.listFactory = listFactory;
	}

}
