package br.com.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.BaseDao;
import br.com.dao.MarcaDAO;
import br.com.entidades.Marca;

@Stateless
public class MarcaService extends BaseService<Marca> {

	@Inject
	private MarcaDAO dao;

	@Override
	public Class<Marca> getClasse() {
		return Marca.class;
	}

	@Override
	protected BaseDao<Marca> getDao() {
		return dao;
	}

}
