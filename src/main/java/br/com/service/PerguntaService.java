package br.com.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.BaseDao;
import br.com.dao.PerguntaDAO;
import br.com.entidades.Pergunta;
import br.com.entidades.Usuario;

@Stateless
public class PerguntaService extends BaseService<Pergunta> {

	@Inject
	private PerguntaDAO dao;

	public List<Pergunta> getPerguntas(Usuario u) {
		return dao.getPerguntas(u);
	}

	@Override
	public Class<Pergunta> getClasse() {
		return Pergunta.class;
	}

	@Override
	protected BaseDao<Pergunta> getDao() {
		return dao;
	}
}
