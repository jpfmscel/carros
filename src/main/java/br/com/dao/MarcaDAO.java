package br.com.dao;

import br.com.entidades.Marca;

public class MarcaDAO extends BaseDao<Marca> {

	@Override
	public Class<Marca> getClasse() {
		return Marca.class;
	}

}
