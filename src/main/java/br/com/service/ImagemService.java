package br.com.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.BaseDao;
import br.com.dao.ImagemDAO;
import br.com.entidades.Imagem;

@Stateless
public class ImagemService extends BaseService<Imagem> {

	@Inject
	private ImagemDAO imagemDao;


	@Override
	public Class<Imagem> getClasse() {
		return Imagem.class;
	}

	@Override
	protected BaseDao<Imagem> getDao() {
		return imagemDao;
	}
}