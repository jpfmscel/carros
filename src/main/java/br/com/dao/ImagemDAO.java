package br.com.dao;

import br.com.entidades.Imagem;

public class ImagemDAO extends BaseDao<Imagem>{

	private static final long serialVersionUID = 1L;

	@Override
	public Class<Imagem> getClasse() {
		return Imagem.class;
	}

}
